package View;

import DAO.ThanhVienDAO;
import Model.ThanhVien;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.*;

/**
 *
 * @author xuant
 */
public class Register extends javax.swing.JFrame {

    /**
     * Creates new form SignUp
     */
    //lưu url hình ảnh
    String hinhAnh = "default.jpg";
    
    public Register() {
        initComponents();
        //gọi hàm add event
        addEvent();
    }

    //hàm add event cho textfield
    private void addEvent() {
        JTextField txt[] = {txtFirstname, txtLastname, txtEmail, txtUsername, txtPassword, txtConfirm};
        for (JTextField jtf : txt) {
            jtf.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    jtf.setText(null);
                }

                @Override
                public void mousePressed(MouseEvent me) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void mouseReleased(MouseEvent me) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void mouseEntered(MouseEvent me) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void mouseExited(MouseEvent me) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
        }
    }

    //hàm kiểm tra dữ liệu nhập
    private boolean validateData() {
        JLabel jlb[] = {lblFirstname, lblLastname, lblEmail, lblUsername, lblPassword, lblConfirm};
        JTextField jtx[] = {txtFirstname, txtLastname, txtEmail, txtUsername, txtPassword, txtConfirm};

        //kiểm tra để trống
        int len = jtx.length;
        for (int i = 0; i < len; i++) {
            if (jtx[i].getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(this, "Vui lòng không để trống " + jlb[i].getText());
                jtx[i].requestFocus();
                return false;
            }
        }
        //kiểm tra định dạng email
        String email = txtEmail.getText();
        if (!email.endsWith("@fpt.edu.vn")) {
            JOptionPane.showMessageDialog(this, "Vui lòng sử dụng email Fpt!");
            txtEmail.requestFocus();
            return false;
        }
        //kiểm tra username tồn tại
        String username = txtUsername.getText();
        ThanhVien tv = ThanhVienDAO.selectByUsername(username);
        if (tv != null) {
            JOptionPane.showMessageDialog(this, "Tên tài khoản đã được đăng ký, vui lòng sử dụng tên tài khoản khác");
            txtUsername.requestFocus();
            return false;
        }
        /*
            kiểm tra password
                i. Kiểm tra độ dài >= 6
                ii. Kiểm tra password và confirm khớp
         */
        String password = String.valueOf(txtPassword.getPassword());
        if (password.trim().length() < 6) {
            JOptionPane.showMessageDialog(this, "Password không đủ mạng, vui lòng nhập password >= 6 kí tự");
            txtPassword.requestFocus();
            return false;
        }
        String confirm = String.valueOf(txtConfirm.getPassword());
        if (!password.equals(confirm)) {
            JOptionPane.showMessageDialog(this, "Confirm không khớp password, vui lòng nhập lại.");
            txtConfirm.requestFocus();
            return false;
        }
        return true;
    }
    
    //hàm lấy dữ liệu từ form
    private ThanhVien getForm(){
        ThanhVien tv = new ThanhVien();
        //lấy mã thành viên
        int maTV = ThanhVienDAO.getMaTV() + 1;
        tv.setMaTV(maTV);
        //lấy tài khoản
        tv.setTaiKhoan(txtUsername.getText());
        //lấy mật khẩu
        tv.setMatKhau(String.valueOf(txtPassword.getPassword()));
        //lấy họ và tên
        tv.setHoTen(txtLastname.getText() + " " + txtFirstname.getText());
        //lấy giới tính
        tv.setGioiTinh(buttonGroup1.getSelection().getActionCommand());
        //lấy email
        tv.setEmail(txtEmail.getText());
        //lấy hình ảnh
        tv.setHinhAnh(hinhAnh);
        //vai trò thành viên
        tv.setMaVT(2);
        //lấy ngày đăng ký
        tv.setNgayDangKy(new Date());
        return tv;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtFirstname = new javax.swing.JTextField();
        txtLastname = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        rdoMale = new javax.swing.JRadioButton();
        rdoFemale = new javax.swing.JRadioButton();
        txtUsername = new javax.swing.JTextField();
        btnRegister = new javax.swing.JButton();
        btnUpload = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        txtConfirm = new javax.swing.JPasswordField();
        lblFirstname = new javax.swing.JLabel();
        lblLastname = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblConfirm = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Register Here");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/English.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("-----Register-----");

        txtFirstname.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N

        txtLastname.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N

        buttonGroup1.add(rdoMale);
        rdoMale.setSelected(true);
        rdoMale.setText("Male");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, rdoMale, org.jdesktop.beansbinding.ELProperty.create("Male"), rdoMale, org.jdesktop.beansbinding.BeanProperty.create("actionCommand"));
        bindingGroup.addBinding(binding);

        buttonGroup1.add(rdoFemale);
        rdoFemale.setText("Female");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, rdoFemale, org.jdesktop.beansbinding.ELProperty.create("Female"), rdoFemale, org.jdesktop.beansbinding.BeanProperty.create("actionCommand"));
        bindingGroup.addBinding(binding);

        txtUsername.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N

        btnRegister.setBackground(new java.awt.Color(0, 0, 255));
        btnRegister.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.setText("Register");
        btnRegister.setOpaque(false);
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnUpload.setText("Upload Image");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        lblFirstname.setText("Firstname");

        lblLastname.setText("Lastname");

        lblEmail.setText("Email");

        lblUsername.setText("Username");

        lblPassword.setText("Password");

        lblConfirm.setText("Confirm");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(63, 63, 63))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsername)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(rdoMale)
                                    .addGap(18, 18, 18)
                                    .addComponent(rdoFemale)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnUpload))
                                .addComponent(txtEmail)
                                .addComponent(txtUsername)
                                .addComponent(txtPassword)
                                .addComponent(txtConfirm)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblFirstname)
                                        .addComponent(lblEmail))
                                    .addGap(28, 28, 28)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblLastname)
                                        .addComponent(txtLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(lblPassword)
                            .addComponent(lblConfirm))))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtFirstname, txtLastname});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFirstname)
                            .addComponent(lblLastname))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEmail)
                .addGap(10, 10, 10)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoMale)
                    .addComponent(rdoFemale)
                    .addComponent(btnUpload))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsername)
                .addGap(11, 11, 11)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblConfirm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnUpload, txtConfirm, txtEmail, txtPassword, txtUsername});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(315, 315, 315)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        JFileChooser jfc = new JFileChooser();
        int i = jfc.showOpenDialog(this);
        if (i == JFileChooser.APPROVE_OPTION) {
            File file = jfc.getSelectedFile();
            String path = file.getAbsolutePath();
            hinhAnh = path.substring(path.lastIndexOf("\\") + 1);
        }
    }//GEN-LAST:event_btnUploadActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        try {
            //kiểm tra dữ liệu nhập vào
            if(!validateData()) return;
            //lấy dữ liệu từ form
            ThanhVien tv = getForm();
            //thêm vào database
            boolean flag = ThanhVienDAO.insert(tv);
            if(flag){
                JOptionPane.showMessageDialog(this, "Đăng ký thành công!");
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(this, "Đăng ký thất bại, vui lòng thử lại.");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnRegisterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnUpload;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblConfirm;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFirstname;
    private javax.swing.JLabel lblLastname;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JPasswordField txtConfirm;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstname;
    private javax.swing.JTextField txtLastname;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
