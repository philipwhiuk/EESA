package eesa.gui.tables;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputListener;
import javax.swing.plaf.basic.BasicTableHeaderUI;
import javax.swing.table.TableColumnModel;
/**
 * Provides implementation of 
 * {@link javax.swing.plaf.TableHeaderUI} for data mapping tables.
 * @author Philip
 */
class DataMapTableHeaderUI extends BasicTableHeaderUI {

    @Override
  protected MouseInputListener createMouseInputListener() {
    return new MouseInputHandler((DataMapTableHeader) header);
  }

    /**
     * 
     */
    public class MouseInputHandler extends BasicTableHeaderUI.MouseInputHandler {
        /**
         * 
         */
        private Component dispatchComponent;

        /**
         * 
         */
        private DataMapTableHeader header;

    /**
     * 
     * @param h header
     */
    public MouseInputHandler(final DataMapTableHeader h) {
      this.header = h;
    }

    /**
     * 
     * @param e
     */
    private void setDispatchComponent(final MouseEvent e) {
      Component editorComponent = header.getEditorComponent();
      Point p = e.getPoint();
      Point p2 = SwingUtilities.convertPoint(header, p, editorComponent);
      dispatchComponent = SwingUtilities.getDeepestComponentAt(
          editorComponent, p2.x, p2.y);
    }

    /**
     * 
     * @param e
     * @return
     */
    private boolean repostEvent(final MouseEvent e) {
      if (dispatchComponent == null) {
        return false;
      }
      MouseEvent e2 = SwingUtilities.convertMouseEvent(header, e,
          dispatchComponent);
      dispatchComponent.dispatchEvent(e2);
      return true;
    }

    @Override
    public void mousePressed(final MouseEvent e) {
      if (!SwingUtilities.isLeftMouseButton(e)) {
        return;
      }
      super.mousePressed(e);

      if (header.getResizingColumn() == null) {
        Point p = e.getPoint();
        TableColumnModel columnModel = header.getColumnModel();
        int index = columnModel.getColumnIndexAtX(p.x);
        if (index != -1) {
          if (header.editCellAt(index, e)) {
            setDispatchComponent(e);
            repostEvent(e);
          }
        }
      }
    }

        @Override
    public void mouseReleased(final MouseEvent e) {
      super.mouseReleased(e);
      if (!SwingUtilities.isLeftMouseButton(e)) {
        return;
      }
      repostEvent(e);
      dispatchComponent = null;
    }

  }

}