/*
 * AboutWindow.java
 *
 * Created on 07-Feb-2012, 14:16:25
 */

package eesa.gui.windows;

import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;

/**
 * Shows information about EESA.
 * @author Philip
 */
public class AboutWindow extends javax.swing.JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
	private GroupLayout layout;

    /** Creates new form AboutWindow. */
    public AboutWindow() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	createFields();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ESA Simulator :: About");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Energy Scheduling Algorithms Simulator");
        jLabel1.setOpaque(true);

        jLabel2.setFont(
        		new java.awt.Font("Tahoma", 1,
        				eesa.gui.Application.FONT_SIZE));
        jLabel2.setText("Produced by:");

        jLabel3.setFont(
        		new java.awt.Font("Tahoma", 1,
        				eesa.gui.Application.FONT_SIZE));
        jLabel3.setText("Project Supervisor:");

        jLabel4.setText("Philip Whitehouse");

        jLabel5.setText("Dr. Paul C. Bell");

        jLabel6.setFont(
        		new java.awt.Font("Tahoma", 1,
        				eesa.gui.Application.FONT_SIZE));
        jLabel6.setText("University:");

        jLabel7.setText("Loughborough University");

        jLabel8.setFont(
        		new java.awt.Font("Tahoma", 1,
        				eesa.gui.Application.FONT_SIZE)); // NOI18N
        jLabel8.setText("Version:");

        jLabel9.setText("1.0");

        jLabel10.setFont(
        		new java.awt.Font("Tahoma", 1,
        				eesa.gui.Application.FONT_SIZE)); // NOI18N
        jLabel10.setText("Algorithms:");

        jLabel11.setText("Dual Classified Round-Robin Algorithm");

        jLabel12.setText("Classified Round-Robin Algorithm");

        jLabel13.setText("Round-Robin Algorithm");

        jLabel14.setText("YDS Algorithm");

        jLabel15.setText("OA Algorithm");

        jLabel16.setText("AVR Algorithm");

        jLabel17.setText("Naive Job Completion Algorithm");

        jLabel18.setText("Naive Maximum Density Algorithm");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1,
        		eesa.gui.Application.FONT_SIZE)); // NOI18N
        jLabel19.setText("Database Connectors:");

        jLabel20.setText("MySQL Connector/J (com.mysql.*)");

        jLabel21.setText("Available under GPLv2 license from MySQL AB ");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1,
        		eesa.gui.Application.FONT_SIZE)); // NOI18N
        jLabel22.setText("User Interfaces");

        jLabel23.setText("Java Swing (javax.swing.*)");

        jLabel24.setText("Distributed as part of the standard JVM");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1,
        		eesa.gui.Application.FONT_SIZE)); // NOI18N
        jLabel25.setText("Help Manager");

        jLabel26.setText("JavaHelp (javax.help.*)");

        jLabel27.setText("Distributed complete and unmodified");

        jLabel28.setText(" under Sun Binary Code License Agreement");

        jLabel29.setText("Paul C. Bell and Prudence W.H. Wong");

        jLabel30.setText("S. Albers, F. Muller and S. Schmelzer");

        jLabel31.setText("Frances Yao, Alan Demers, Scott Shenker");

        jLabel32.setText("Rachel Ferst and Alan Papir ");

        jLabel33.setText("Rachel Ferst and Alan Papir ");

        jLabel34.setText("Frances Yao, Alan Demers, Scott Shenker");

        jLabel35.setText("Frances Yao, Alan Demers, Scott Shenker");

        jLabel36.setText("S. Albers, F. Muller and S. Schmelzer");

        jLabel37.setText("Swing Layout Extensions (java.*)");

        jLabel38.setText("Available under LGPLv2.1 license from java.net ");

        buildLayout();

        pack();
    }
    /**
     * 
     */
    private void buildLayout() {
        layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.LEADING)
            .add(GroupLayout.TRAILING, jLabel1, GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(GroupLayout.LEADING)
                    .add(jLabel3)
                    .add(jLabel2)
                    .add(jLabel6)
                    .add(jLabel8))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(GroupLayout.LEADING)
                    .add(jLabel7)
                    .add(layout.createParallelGroup(GroupLayout.LEADING, false)
                        .add(jLabel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jLabel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(jLabel9))
                .addContainerGap(289, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel22)
                .addContainerGap(447, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(GroupLayout.LEADING)
                    .add(layout.createParallelGroup(GroupLayout.TRAILING, false)
                        .add(GroupLayout.LEADING, jLabel19,
                        		GroupLayout.DEFAULT_SIZE,
                        		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(GroupLayout.LEADING, jLabel18,
                        		GroupLayout.DEFAULT_SIZE,
                        		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(GroupLayout.LEADING, jLabel11,
                        		GroupLayout.DEFAULT_SIZE,
                        		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(GroupLayout.LEADING, jLabel12,
                        		GroupLayout.DEFAULT_SIZE,
                        		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(GroupLayout.LEADING, jLabel13,
                        		GroupLayout.DEFAULT_SIZE,
                        		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(GroupLayout.LEADING, jLabel14,
                        		GroupLayout.DEFAULT_SIZE,
                        		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(GroupLayout.LEADING, jLabel15,
                        		GroupLayout.DEFAULT_SIZE,
                        		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(GroupLayout.LEADING, jLabel16,
                        		GroupLayout.DEFAULT_SIZE,
                        		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(GroupLayout.LEADING, jLabel17,
                        		GroupLayout.DEFAULT_SIZE,
                        		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(GroupLayout.LEADING, jLabel10,
                        		GroupLayout.DEFAULT_SIZE,
                        		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(jLabel20, GroupLayout.PREFERRED_SIZE, 180,
                    		GroupLayout.PREFERRED_SIZE)
                    .add(jLabel23)
                    .add(jLabel25)
                    .add(jLabel26)
                    .add(jLabel37))
                .add(36, 36, 36)
                .add(layout.createParallelGroup(GroupLayout.LEADING)
                    .add(jLabel28)
                    .add(jLabel38)
                    .add(jLabel24)
                    .add(jLabel21)
                    .add(jLabel29)
                    .add(jLabel30)
                    .add(jLabel31)
                    .add(jLabel32)
                    .add(jLabel33)
                    .add(jLabel34)
                    .add(jLabel35)
                    .add(jLabel36)
                    .add(jLabel27))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        buildLayoutVertical();
	}
    /**
     * 
     */
	private void buildLayoutVertical() {
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.LEADING)
                .add(layout.createSequentialGroup()
                    .add(jLabel1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.UNRELATED)
                    .add(layout.createParallelGroup(GroupLayout.BASELINE)
                        .add(jLabel2)
                        .add(jLabel4))
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(layout.createParallelGroup(GroupLayout.BASELINE)
                        .add(jLabel3)
                        .add(jLabel5))
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(layout.createParallelGroup(GroupLayout.BASELINE)
                        .add(jLabel6)
                        .add(jLabel7))
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(layout.createParallelGroup(GroupLayout.BASELINE)
                        .add(jLabel8)
                        .add(jLabel9))
                    .addPreferredGap(LayoutStyle.UNRELATED)
                    .add(jLabel10)
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(layout.createParallelGroup(GroupLayout.BASELINE)
                        .add(jLabel11)
                        .add(jLabel29))
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(layout.createParallelGroup(GroupLayout.BASELINE)
                        .add(jLabel12)
                        .add(jLabel30))
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(layout.createParallelGroup(GroupLayout.BASELINE)
                        .add(jLabel13)
                        .add(jLabel36))
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(layout.createParallelGroup(GroupLayout.BASELINE)
                        .add(jLabel14)
                        .add(jLabel34))
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(layout.createParallelGroup(GroupLayout.BASELINE)
                        .add(jLabel15)
                        .add(jLabel35))
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(layout.createParallelGroup(GroupLayout.BASELINE)
                        .add(jLabel16)
                        .add(jLabel31))
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(layout.createParallelGroup(GroupLayout.BASELINE)
                        .add(jLabel17)
                        .add(jLabel32))
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(layout.createParallelGroup(GroupLayout.BASELINE)
                        .add(jLabel18)
                        .add(jLabel33))
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(jLabel19)
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(layout.createParallelGroup(GroupLayout.BASELINE)
                        .add(jLabel20)
                        .add(jLabel21))
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(jLabel22)
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(layout.createParallelGroup(GroupLayout.BASELINE)
                        .add(jLabel23)
                        .add(jLabel24))
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(layout.createParallelGroup(GroupLayout.BASELINE)
                        .add(jLabel37)
                        .add(jLabel38))
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(layout.createParallelGroup(GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                            .add(jLabel25)
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(jLabel26))
                        .add(layout.createSequentialGroup()
                            .add(20, 20, 20)
                            .add(jLabel27)))
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(jLabel28)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
	}

	/**
     * 
     */
    private void createFields() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
    /**
     * 
     */
    private javax.swing.JLabel jLabel1;
    /**
     * 
     */
    private javax.swing.JLabel jLabel10;
    /**
     * 
     */
    private javax.swing.JLabel jLabel11;
    /**
     * 
     */
    private javax.swing.JLabel jLabel12;
    /**
     * 
     */
    private javax.swing.JLabel jLabel13;
    /**
     * 
     */
    private javax.swing.JLabel jLabel14;
    /**
     * 
     */
    private javax.swing.JLabel jLabel15;
    /**
     * 
     */
    private javax.swing.JLabel jLabel16;
    /**
     * 
     */
    private javax.swing.JLabel jLabel17;
    /**
     * 
     */
    private javax.swing.JLabel jLabel18;
    /**
     * 
     */
    private javax.swing.JLabel jLabel19;
    /**
     * 
     */
    private javax.swing.JLabel jLabel2;
    /**
     * 
     */
    private javax.swing.JLabel jLabel20;
    /**
     * 
     */
    private javax.swing.JLabel jLabel21;
    /**
     * 
     */
    private javax.swing.JLabel jLabel22;
    /**
     * 
     */
    private javax.swing.JLabel jLabel23;
    /**
     * 
     */
    private javax.swing.JLabel jLabel24;
    /**
     * 
     */
    private javax.swing.JLabel jLabel25;
    /**
     * 
     */
    private javax.swing.JLabel jLabel26;
    /**
     * 
     */
    private javax.swing.JLabel jLabel27;
    /**
     * 
     */
    private javax.swing.JLabel jLabel28;
    /**
     * 
     */
    private javax.swing.JLabel jLabel29;
    /**
     * 
     */
    private javax.swing.JLabel jLabel3;
    /**
     * 
     */
    private javax.swing.JLabel jLabel30;
    /**
     * 
     */
    private javax.swing.JLabel jLabel31;
    /**
     * 
     */
    private javax.swing.JLabel jLabel32;
    /**
     * 
     */
    private javax.swing.JLabel jLabel33;
    /**
     * 
     */
    private javax.swing.JLabel jLabel34;
    /**
     * 
     */
    private javax.swing.JLabel jLabel35;
    /**
     * 
     */
    private javax.swing.JLabel jLabel36;
    /**
     * 
     */
    private javax.swing.JLabel jLabel37;
    /**
     * 
     */
    private javax.swing.JLabel jLabel38;
    /**
     * 
     */
    private javax.swing.JLabel jLabel4;
    /**
     * 
     */
    private javax.swing.JLabel jLabel5;
    /**
     * 
     */
    private javax.swing.JLabel jLabel6;
    /**
     * 
     */
    private javax.swing.JLabel jLabel7;
    /**
     * 
     */
    private javax.swing.JLabel jLabel8;
    /**
     * 
     */
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables

}
