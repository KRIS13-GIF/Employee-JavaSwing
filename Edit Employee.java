/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_project;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.text.*;
/**
 *
 * @author user
 */
public class EditEmployee extends javax.swing.JFrame {
    ArrayList<Job>jobs;
    ArrayList<Employee>employees;
    DecimalFormat formatter;


    /**
     * Creates new form EditEmployee
     */
    public EditEmployee() {
        initComponents();
        formatter = new DecimalFormat("#, ###.00"); 
        jobs=new ArrayList<Job>();
        employees=new ArrayList<Employee>();
         
        
        populateArrayList(); // used for the combobox process
        // it wil go to the jobs data files and will populate the job arraylists
        // it will also go to the employees data files and will populate also the employees arraylist
    
    
        String[] jobsArray=new String[jobs.size()];
        for (int i=0; i<jobs.size(); i++){
            jobsArray[i]=jobs.get(i).getNameOfJob() + ", R" +formatter.format(jobs.get(i).getSalary());
        }
         jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(jobsArray));
      
         
         // the same thing is done for the employees
        String[] empArray=new String[employees.size()];
        
         for (int i=0; i<employees.size(); i++){
            empArray[i]=employees.get(i).getName() + ", " + employees.get(i).getSurname();
        }
         jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(empArray));
         jComboBox1.setSelectedIndex(0); // when the textfields autofill , it starts from the first
    }
    
    public void populateArrayList(){
        try{
            // when we read objects we use file input
            FileInputStream file = new FileInputStream("Jobs.dat"); // we are working with data files which are part of the system
            ObjectInputStream inputFile = new ObjectInputStream(file); // this will help us to read from the file 
            
            boolean endOfFile= false; // it reads until it comes to the end of file
            
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
        
        
        // this try catch is for the employees
        try{
            // when we read objects we use file input
            FileInputStream file2 = new FileInputStream("Employees.dat"); // we are working with data files which are part of the system
            ObjectInputStream inputFile2 = new ObjectInputStream(file2); // this will help us to read from the file 
            
            boolean endOfFile= false;
            
            while (!endOfFile)
            {
                
                try{
                    
                    employees.add((Employee)inputFile2.readObject()); // reads the objects from the file and adds them in an arraylist
                    
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
            inputFile2.close();
            
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        
    }
    
    
    
    // This is a method to be done after you click SAVE
     public void saveEmployeesToFile(){
        try{
            // to write to file we use outputstream
            FileOutputStream file = new FileOutputStream("Employees.dat"); // goes to back to Jobs file
            ObjectOutputStream outputFile= new ObjectOutputStream(file);
            
            for (int i=0; i<employees.size(); i++)
            {
                outputFile.writeObject(employees .get(i)); // it will get the object from the arraylist and will save it to the file Jobs
                
            }
            outputFile.close();
                        JOptionPane.showMessageDialog(null, "Successfully saved !");
                        this.dispose(); // closes the window
            
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
     }
        
        
        
        // this method is the same like the first one used for saving but this is used for deleting  button 
        
          public void saveEmployeesToFileDelete(){
        try{
            // to write to file we use outputstream
            FileOutputStream file = new FileOutputStream("Employees.dat"); // goes to back to Jobs file
            ObjectOutputStream outputFile= new ObjectOutputStream(file);
            
            for (int i=0; i<employees.size(); i++)
            {
                outputFile.writeObject(employees .get(i)); // it will get the object from the arraylist and will save it to the file Jobs
                
            }
            outputFile.close();
                        JOptionPane.showMessageDialog(null, "Successfully deleted !");
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Employee details");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Edit Employee data:");

        jLabel2.setText("Choose employee: ");

        jLabel3.setText("Employee name: ");

        jLabel4.setText("Employee surname: ");

        jLabel5.setText("Employee staff number: ");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel6.setText("Employee job: ");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_project/exit.png"))); // NOI18N
        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_project/save.png"))); // NOI18N
        jButton2.setText("save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4)
                                .addComponent(jLabel6))
                            .addGap(27, 27, 27)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jComboBox1, 0, 178, Short.MAX_VALUE)
                                .addComponent(jTextField1)
                                .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField2)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(107, 107, 107)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jButton2)
                        .addGap(38, 38, 38)
                        .addComponent(jButton1)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addComponent(jLabel3))
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addComponent(jLabel4))
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
   
        // optional thing done in this program
        
        int selectedIndex=jComboBox1.getSelectedIndex(); // now you know which employee you are talking about
        
        // this operation here autofills the fields in the edit area
        jTextField1.setText(employees.get(selectedIndex).getName()); // autofill 
        jTextField2.setText(employees.get(selectedIndex).getSurname());
        jTextField3.setText(employees.get(selectedIndex).getStaffNr()+ " ");
        
        
        // Now we need to autofill every element which we select
        Job job=employees.get(selectedIndex).getJob();
        int index=0;
        for(int i=0; i<jobs.size();i++){
            if(jobs.get(i).equals(job)) // if the value is the same like that in the combobx 
            {
                index=i;
                break; 
            }
        }
        jComboBox2.setSelectedIndex(index);
        


        // TODO add your handling code here:
    }                                          

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         

        
     if(jTextField1.getText().isEmpty() || jTextField2.getText().isEmpty() || jTextField3.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please enter all fields");
        }
     else{
        int selectedIndex=jComboBox1.getSelectedIndex(); // make sure you are working with an object which is in the combobox
        employees.get(selectedIndex).setName(jTextField1.getText().trim());  // update the line 
        employees.get(selectedIndex).setSurname(jTextField2.getText().trim());  // update the line 
        employees.get(selectedIndex).setStaffNr(Integer.parseInt(jTextField3.getText().trim()));  // update the line 
        Job job=jobs.get(jComboBox2.getSelectedIndex());
        employees.get(selectedIndex).setJob(job);  // update the line by setting the job 
        
        saveEmployeesToFile(); // calling the method
        
       
        }


        
    }                                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
                    
    int selectedIndex=jComboBox1.getSelectedIndex(); // now you know which employee you are talking about
    
    employees.remove(selectedIndex); // removes the employee from the arraylist
    
    saveEmployeesToFileDelete();



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
            java.util.logging.Logger.getLogger(EditEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditEmployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration                   
}
