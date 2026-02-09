import javax.swing.*;               
import javax.swing.table.DefaultTableModel;  
import java.sql.*;                 
import java.awt.*;

public class StudentListFrame extends javax.swing.JFrame {

   
    public StudentListFrame() {
        
        initComponents();
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) {
            
            int studentId = (int) jTable1.getValueAt(selectedRow, 0);

            
            ExamResultsFrame examFrame = new ExamResultsFrame(studentId);
            examFrame.setVisible(true);
        }
    }
});

        
    String[] columns = {"ID", "Student Number", "Name", "Surname", "Department", "Gender"};

    
    DefaultTableModel model = new DefaultTableModel();
    model.setColumnIdentifiers(columns);

    
    jTable1.setModel(model);

   
    loadStudents(model);
    setSize(800, 400);            
setLocationRelativeTo(null);  
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
setVisible(true);
    }
   
    private void loadStudents(DefaultTableModel model) {
    try {
        Connection conn = DBConnection.connect(); 

        String sql = "SELECT * FROM students";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        
        while (rs.next()) {
            int id = rs.getInt("id");
            String number = rs.getString("student_number");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String department = rs.getString("department");
            String gender = rs.getString("gender");

            model.addRow(new Object[]{id, number, name, surname, department, gender});
        }
        conn.close();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error loading students from database.");
    }
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Student List");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentListFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
