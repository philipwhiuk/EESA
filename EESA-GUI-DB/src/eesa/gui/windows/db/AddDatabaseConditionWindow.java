/*
 * AddDatabaseConditionWindow.java
 *
 * Created on 05-Apr-2012, 10:45:11
 */
package eesa.gui.windows.db;

import javax.swing.ButtonGroup;

import eesa.db.DatabaseValue;
import eesa.db.Field;
import eesa.db.Operator;
import eesa.db.QueryObject;
import eesa.db.SQLObject;
import eesa.db.SelectQuery;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

/**
 * Provides a window to add a database condition.
 * @author Philip
 */
public class AddDatabaseConditionWindow extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private DatabaseWindow parent;
    /**
     * 
     */
    private SelectQuery query;
    /**
     * 
     */
    private QueryObject queryObject;
    /** Creates new form AddDatabaseConditionWindow.
     * @param window 
     */
    public AddDatabaseConditionWindow(final DatabaseWindow window) {
        parent = window;
        initComponents();
    }

    /** 
     * This method is called from within the constructor to
     * initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {

        valueRadioButtonGroup = new ButtonGroup();
        heading = new JLabel();
        fieldLabel = new JLabel();
        fieldComboBox = new JComboBox<Field>();
        operatorComboBox = new JComboBox<Operator>();
        operatorLabel = new JLabel();
        valueLabel = new JLabel();
        valFieldComboBox = new JComboBox<Field>();
        valFieldRadioButton = new JRadioButton();
        valValueRadioButton = new JRadioButton();
        valValueField = new JTextField();
        valQueryRadioButton = new JRadioButton();
        valGenerateQueryButton = new JButton();
        addButton = new JButton();
        cancelButton = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Condition");

        heading.setFont(new java.awt.Font("Tahoma", 1,
        		eesa.gui.Application.HEADING_FONT_SIZE));
        heading.setText("Add Condition");

        fieldLabel.setFont(new java.awt.Font("Tahoma", 1,
        		eesa.gui.Application.FONT_SIZE));
        fieldLabel.setText("Field");

        fieldComboBox.setModel(getFields());

        operatorComboBox.setModel(getOperators());

        operatorLabel.setFont(new java.awt.Font("Tahoma", 1,
        		eesa.gui.Application.FONT_SIZE));
        operatorLabel.setText("Operator");

        valueLabel.setFont(new java.awt.Font("Tahoma", 1,
        		eesa.gui.Application.FONT_SIZE));
        valueLabel.setText("Value Type");

        valFieldComboBox.setModel(getFields());

        valueRadioButtonGroup.add(valFieldRadioButton);
        valFieldRadioButton.setText("Field");
        valFieldRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                valFieldRadioButtonActionPerformed(evt);
            }
        });

        valueRadioButtonGroup.add(valValueRadioButton);
        valValueRadioButton.setText("Value");

        valueRadioButtonGroup.add(valQueryRadioButton);
        valQueryRadioButton.setText("Query");

        valGenerateQueryButton.setText("Generate Query");
        valGenerateQueryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                valGenerateQueryButtonActionPerformed(evt);
            }
        });

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(heading, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldLabel, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(operatorLabel)
                                    .addComponent(valueLabel)
                                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(valValueRadioButton, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(valFieldRadioButton, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                                        .addComponent(valQueryRadioButton)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(valValueField)
                                    .addComponent(valGenerateQueryButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(valFieldComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(operatorComboBox, 0, 120, Short.MAX_VALUE)
                                    .addComponent(fieldComboBox, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(101, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                        .addGap(232, 232, 232))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(heading)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldLabel)
                    .addComponent(fieldComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(operatorComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(operatorLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(valueLabel)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(valFieldRadioButton)
                    .addComponent(valFieldComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(valValueRadioButton)
                    .addComponent(valValueField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(valQueryRadioButton)
                    .addComponent(valGenerateQueryButton))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(cancelButton))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }
   
    /**
     * 
     * @param evt
     */
    private void valFieldRadioButtonActionPerformed(final java.awt.event.ActionEvent evt) {
    }
    /**
     * 
     * @param evt
     */
    private void valGenerateQueryButtonActionPerformed(final java.awt.event.ActionEvent evt) {
        if (queryObject == null) {
            queryObject = new QueryObject(parent.getDatabaseConnector(), parent.getDatabase());
        }
        new BuildRetrievalQueryWindow(this, queryObject).setVisible(true);
    }
    
    /**
     * 
     * @param evt
     */
    private void addButtonActionPerformed(final java.awt.event.ActionEvent evt) {
        SQLObject lhs;
        Operator op;
        SQLObject rhs;
        if ((fieldComboBox.getSelectedItem() != null) && (operatorComboBox.getSelectedItem() != null) 
                && (valueRadioButtonGroup.getSelection() != null)) {
            lhs = (Field) fieldComboBox.getSelectedItem();
            op = (Operator) operatorComboBox.getSelectedItem();
        } else {
            return;
        }
        if (valueRadioButtonGroup.getSelection() instanceof JRadioButton.ToggleButtonModel) {
            if (valueRadioButtonGroup.getSelection().equals(valFieldRadioButton.getModel())) {
                if (valFieldComboBox.getSelectedItem() != null) {
                    rhs = (Field) valFieldComboBox.getSelectedItem();
                } else {
                    return;
                }
            } else if (valueRadioButtonGroup.getSelection().equals(valValueRadioButton.getModel())) {
                rhs = new DatabaseValue(valValueField.getText());
            } else if (valueRadioButtonGroup.getSelection().equals(valQueryRadioButton.getModel())) {
                rhs = query;
            } else {
                return;
            }
        } else {
            return;
        }        
        parent.setCondition(parent.getDatabase().where(lhs, op, rhs));
        dispose();        
}
    /**
     * 
     * @param evt
     */
    private void cancelButtonActionPerformed(final java.awt.event.ActionEvent evt) {
        this.dispose();
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
     * 
     */
    private JButton addButton;
    /**
     * 
     */
    private JButton cancelButton;
    /**
     * 
     */
    private JComboBox<Field> fieldComboBox;
    /**
     * 
     */
    private JLabel fieldLabel;
    /**
     * 
     */
    private JLabel heading;
    /**
     * 
     */
    private JComboBox<Operator> operatorComboBox;
    /**
     * 
     */
    private JLabel operatorLabel;
    /**
     * 
     */
    private JComboBox<Field> valFieldComboBox;
    /**
     * 
     */
    private JRadioButton valFieldRadioButton;
    /**
     * 
     */
    private JButton valGenerateQueryButton;
    /**
     * 
     */
    private JRadioButton valQueryRadioButton;
    /**
     * 
     */
    private JTextField valValueField;
    /**
     * 
     */
    private JRadioButton valValueRadioButton;
    /**
     * 
     */
    private JLabel valueLabel;
    /**
     * 
     */
    private ButtonGroup valueRadioButtonGroup;
    // End of variables declaration//GEN-END:variables

    /**
     * 
     * @return
     */
    private ComboBoxModel<Field> getFields() {
        return new DefaultComboBoxModel<Field>(parent.getFields());
    }

    /**
     * 
     * @return
     */
    private ComboBoxModel<Operator> getOperators() {
        return new DefaultComboBoxModel<Operator>(parent.getOperators());
    }

    /**
     * 
     * @param selectQuery
     */
    final void setQuery(final SelectQuery selectQuery) {
        this.query = selectQuery;
    }
}
