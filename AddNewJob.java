/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_project;
import javax.swing.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author user
 */
public class AddNewJob extends javax.swing.JFrame {

    ArrayList<Job>jobs;
    /**
     * Creates new form AddNewJob
     */
    public AddNewJob() {
        initComponents();
        jobs=new ArrayList<Job>();
        populateArrayList();
    }
    
    public void populateArrayList(){
        try{
            // when we read objects we use file input
            FileInputStream file = new FileInputStream("Jobs.dat"); // we are working with data files which are part of the system
            ObjectInputStream inputFile = new ObjectInputStream(file); // this will help us to read from the file 
            
            boolean endOfFile= false;
            
            while (!endOfFile)
            {
                
                try{
                    
                    jobs.add((Job)inputFile.readObject()); // reads the objects from the file and adds them in an arraylist
                    
                }
                catch (EOFException e)
                        {
                            endOfFile=true;
                }
        
                catch(Exception f)
                {
                    JOptionPane.showMessageDialog(null, f.getMessage());
                }
            }
            inputFile.close();
            
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        
    }
    
    public void saveJobsToFile(){
        try{
            // to write to file we use outputstream
            FileOutputStream file = new FileOutputStream("Jobs.dat"); // goes to back to Jobs file
            ObjectOutputStream outputFile= new ObjectOutputStream(file);
            
            for (int i=0; i<jobs.size(); i++)
            {
                outputFile.writeObject(jobs.get(i)); // it will get the object from the arraylist and will save it to the file Jobs
                
            }
            outputFile.close();
                        JOptionPane.showMessageDialog(null, "Successfully saved !");
                        this.dispose(); // closes the window
            
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jobName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jobSalary = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add new Job");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Create new Job by entering the data below:");

        jLabel2.setText("Name of the job: ");

        jobName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobNameActionPerformed(evt);
            }
        });

        jLabel3.setText("Salary for this job: ");

        jobSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobSalaryActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_project/save.png"))); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jobSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jobName, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jButton1)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jobName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jobSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>                        

    private void jobNameActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void jobSalaryActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         

        // get whatever the user types
        if(jobName.getText().isEmpty() || jobSalary.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Pease enter all fields");
            
          
        }
        else{
        String name= jobName.getText().trim(); // this is the text_field
        String salary=jobSalary.getText().trim(); // takes the salary
        
        Job job=new Job(Double.parseDouble(salary), name); // creating new job object 
        jobs.add(job); // saving the job
        
        saveJobsToFile(); // calling the method 
        }
        
        
       
        



        // TODO add your handling code here:
    }                                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddNewJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNewJob().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jobName;
    private javax.swing.JTextField jobSalary;
    // End of variables declaration                   
}