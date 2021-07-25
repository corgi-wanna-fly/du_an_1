/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MDIView;

import DAO.FormDAO;
import DAO.ThanhVienDAO;
import Model.ThanhVien;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Date;
import javax.swing.*;

/**
 *
 * @author xuant
 */
public class Register extends javax.swing.JInternalFrame {

    /**
     * Creates new form Register
     */
    //lưu url hình ảnh
    String hinhAnh = "default.jpg";

    int res;

    boolean check;

    JDesktopPane jDesktopPane;
    
    public Register(int id, boolean flag, JDesktopPane jdk) {
        initComponents();
        res = id;
        check = flag;
        jDesktopPane = jdk;
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
    private ThanhVien getForm() {
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

        setClosable(true);
        setTitle("Register Here");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 317, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 442, Short.MAX_VALUE)
        );

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/English.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("-----Register-----");

        txtFirstname.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N

        txtLastname.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N

        buttonGroup1.add(rdoMale);
        rdoMale.setSelected(true);
        rdoMale.setText("Male");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, rdoMale, org.jdesktop.beansbinding.ELProperty.create("Nam"), rdoMale, org.jdesktop.beansbinding.BeanProperty.create("actionCommand"));
        bindingGroup.addBinding(binding);

        buttonGroup1.add(rdoFemale);
        rdoFemale.setText("Female");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, rdoFemale, org.jdesktop.beansbinding.ELProperty.create("Nữ"), rdoFemale, org.jdesktop.beansbinding.BeanProperty.create("actionCommand"));
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(63, 63, 63))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmail)
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
                                .addComponent(lblFirstname))
                            .addGap(28, 28, 28)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblLastname)
                                .addComponent(txtLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(lblPassword)
                    .addComponent(lblConfirm))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtFirstname, txtLastname});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFirstname)
                    .addComponent(lblLastname))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFirstname, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
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
                .addGap(13, 13, 13)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblConfirm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtConfirm, txtEmail, txtPassword, txtUsername});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtFirstname, txtLastname});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 313, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        try {
            //kiểm tra dữ liệu nhập vào
            if (!validateData()) {
                return;
            }
            //lấy dữ liệu từ form
            ThanhVien tv = getForm();
            if (check) {
                //thêm vào database
                boolean flag = ThanhVienDAO.insert(tv);
                if (flag) {
                    JOptionPane.showMessageDialog(this, "Đăng ký thành công!");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Đăng ký thất bại, vui lòng thử lại.");
                    return;
                }
            } else {
                tv.setMaTV(res);
                //thêm vào database
                boolean flag = ThanhVienDAO.update(tv);
                if (flag) {
                    JOptionPane.showMessageDialog(this, "Lưu kết quả thành công!");
                    WaitingDisplay waitingDisplay = new WaitingDisplay(jDesktopPane, tv);
                    waitingDisplay.setVisible(true);
                    jDesktopPane.removeAll();
                    jDesktopPane.add(waitingDisplay);
                    FormDAO.centerJIF(jDesktopPane, waitingDisplay);
                    try {
                        waitingDisplay.setSelected(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Lưu kết quả thất bại, vui lòng thử lại.");
                    SignIn signIn = new SignIn(jDesktopPane);
                     jDesktopPane.removeAll();
                    jDesktopPane.add(signIn);
                    FormDAO.centerJIF(jDesktopPane, signIn);
                    try {
                        signIn.setSelected(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        JFileChooser jfc = new JFileChooser();
        int i = jfc.showOpenDialog(this);
        if (i == JFileChooser.APPROVE_OPTION) {
            File file = jfc.getSelectedFile();
            String path = file.getAbsolutePath();
            hinhAnh = path.substring(path.lastIndexOf("\\") + 1);
        }
    }//GEN-LAST:event_btnUploadActionPerformed


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
