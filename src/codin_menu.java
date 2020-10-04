
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @@@@@@@@@@@@@@@@@ 게임 코드의 부모
 */
public class codin_menu extends javax.swing.JPanel {

    BufferedImage im = null;
    int numX = 700;// 단어의 가로 위치
    String[] st = {"print", "for", "if", "else", "while", "def", "class", "char", "int", "public", "void"};//출력하 단어들

    int bar = 100;//프로그래스
    int cout = 0;//점수
    int ran = 0;
    boolean end = false;

    /**
     * Creates new form game2P
     */
    public codin_menu() {
        initComponents();
        try {
            im = ImageIO.read(Menu.class.getResource("10.png"));
        } catch (IOException ex) {
            Logger.getLogger(codin_menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        repaint();//페인트 업데이트
        Thread th = new Thread(new Runnable() {
            //단어 위치 이동
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    numX--;
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(game2P.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    repaint();
                }
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        th.start();
        repaint();
        Thread tt = new Thread(new Runnable() {
            //프로그래스바
            @Override
            public void run() {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                for (int i = 0; i < 100; i++) {
                    if (end) {
                        return;
                    }
                    try {
                        Thread.sleep(1000);//1초마다 감소 하도록
                    } catch (InterruptedException ex) {
                        Logger.getLogger(game2P.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println(ex);
                    }
                    --bar;
                    jProgressBar1.setValue(bar);//프로그래스바 출력
                    if (bar == 0) {
                        not_victory v = new not_victory();//시간이 끝나면 창 출력
                        victory vic = new victory();
                        if (cout > 5) {
                            vic.cout = cout;
                            vic.Gname = "코딩게임";
                            vic.setVisible(true);
                        } else {
                            v.setVisible(true);
                        }
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(game2P.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        v.dispose();//5초 후 not_victory창 제거
                    }
                }
            }
        });

        tt.start();

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        g.drawImage(im, 0, -20, 900 , 583, this);
        
        int b = 1;
        g.drawString(st[ran], numX, 300);
        int ii = 1;
        for (int i = 1; i < st.length; i++) {

            ii++;
            int a = 20 * ii;
            b = numX + (100 * i);
            try {

                g.drawString(st[i], b, a);
            } catch (Exception e) {
                System.out.println(e);
            }
            if (350 < a) {
                ii = 1;
            }
        }

        if (b < -50) {
            numX = 700;
        }

//        Thread tt=new Thread(new Runnable() {
//            @Override
//            public void run() {
//               //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                while (true) { 
//                    //paintComponent(g);
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(game2P.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                   for (int i = 1; i < st.length; i++) {
//                
//                int a=20*i;
//                int b=numX+(100*i);
//                try {
//                  
//                g.drawString(st[i],b, a);
//              } catch (Exception e) {
//                    System.out.println(e);
//              }
//                if(350<a)
//                    a=20;
//              
//            }
//                    
//                }
//               
//            }
//        });
//        tt.start();
    }

    void count() {
        jLabel1.setText("점수 : " + cout);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jProgressBar1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jProgressBar1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("굴림", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("점수 : 0");
        jLabel1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 371, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                while (true) {

                    for (int i = 0; i < st.length; i++) {
                        //같은 단어를 입력하면 단어를 없에고 소리를 추력
                        String ss = jTextField1.getText();
                        if (ss.equals(st[i])) {
                            jTextField1.setText("");//엔터키를 누르면 초기화
                            st[i] = "  ";
                            cout++;
                            count();

                            try {
                                Clip clip1 = AudioSystem.getClip();
                                clip1.open(AudioSystem.getAudioInputStream(
                                        //new File("E:\\song.wav").getAbsoluteFile()));
                                        getClass().getResource("bomb.wav")
                                )
                                );
                                clip1.start();
                            } catch (Exception e) {
                                System.out.println(e);
                            }
//                        if(cout==10){
//                            victory vi=new victory();
//                            vi.setVisible(true);
//                            try {
//                                Thread.sleep(5000);
//                            } catch (InterruptedException ex) {
//                                Logger.getLogger(game2P.class.getName()).log(Level.SEVERE, null, ex);
//                            }
//                            vi.dispose();
//                        }
                            return;
                        }
                    }
                }
            }
        });
        th.start();


    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jLabel1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel1AncestorAdded

    }//GEN-LAST:event_jLabel1AncestorAdded

    private void jProgressBar1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jProgressBar1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jProgressBar1AncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
