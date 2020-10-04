
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
public class kor_game_menu extends javax.swing.JPanel {
    BufferedImage im=null;

int numX=700;// 단어의 가로 위치
String[] st={"평형","선험적","만료","경유","국한","무지","독선적","지적","체화","배제",
             "유체" ,"미미하다","지속적","가령","가상","기획","처리","열람","경감","저해",
             "경합","재원","운용","논외","부류","국면","관조","규범","단초","논변",
             "본위","파급","압제","사익","조장","확립","미감","뭇사람","세사","인습",
             "기성세대","매양","담론","견지","제언","상설","창건","준거","도야","집정"};//출력하 단어들
/*
(평형) 사물이 한쪽으로 기울지 않고 안정해 있음. 
(선험적) 경험에 앞서서 인식의 주관적 형식이 인간에게 있다고 주장하는. 또는 그런 것. 대상 에 관계되지 않고 대상에 대한 인식이 선천적으로 가능함을 밝히려는 인식론적 태도 를 말한다.
(만료) 기한이 다 차서 끝남.
(경유) 어떤 곳을 거쳐 지남.
(국한) 범위를 일정한 부분에 한정함.
(무지) 아는 것이 없음.
(독선적) 자기 혼자만이 옳다고 믿고 행동하는 성향을 가진. 또는 그런 것.
(지적) 지식이나 지성에 관한. 또는 그런 것.
(체화) 물체로 변화함. 또는 물체로 변화하게 함.
(배제) 받아들이지 아니하고 물리쳐 제외함.
(유체) 기체와 액체를 아울러 이르는 말.
(미미하다) 보잘것없이 아주 작다.
(지속적) 어떤 상태가 오래 계속되는. 또는 그런 것.
(가령) (1) 가정하여 말하여. (2) 예를 들어. ‘이를테면’으로 순화.
(가상) 실물처럼 보이는 거짓 형상.
(기획) 일을 꾀하여 계획함.
(처리) 사무나 사건 따위를 절차에 따라 정리하여 치르거나 마무리를 지음.
(열람) 책이나 문서 따위를 죽 훑어보거나 조사하면서 봄.
(경감) 부담이나 고통 따위를 덜어서 가볍게 함.
(저해) 막아서 못하도록 해침.
(경합) 서로 맞서 겨룸. ‘겨룸’, ‘견줌’, ‘경쟁’, ‘다툼’으로 순화.
(재원) 재화나 자금이 나올 원천
(운용) 무엇을 움직이게 하거나 부리어 씀.
(논외) 논의의 범위 밖. 
(부류) 동일한 범주에 속하는 대상들을 일정한 기준에 따라 나누어 놓은 갈래. 
(국면) 어떤 일이 벌어진 장면이나 형편. 
(관조) 고요한 마음으로 사물이나 현상을 관찰하거나 비추어 봄. 
(규범) 인간이 행동하거나 판단할 때에 마땅히 따르고 지켜야 할 가치 판단의 기준.
(단초) 일이나 사건을 풀어 나갈 수 있는 첫머리. 
(논변) 사리의 옳고 그름을 밝히어 말함. 또는 그런 말이나 의견. 
(본위) (1) (흔히 명사 뒤에 쓰여) 판단이나 행동에서 중심이 되는 기준. (2) 본디의 자리.
(파급) 어떤 일의 여파나 영향이 차차 다른 데로 미침. 
(압제) 권력이나 폭력으로 남을 꼼짝 못하게 강제로 누름. 
(사익) 개인의 이익. 
(조장) 바람직하지 않은 일을 더 심해지도록 부추김. 
(확립) 체계나 견해, 조직 따위가 굳게 섬. 또는 그렇게 함. 
(미감) 아름다움에 대한 느낌. 또는 아름다운 느낌. 
(뭇사람) 많은 사람. 또는 여러 사람.
(세사) 세상에서 일어나는 온갖 일. 
(인습) 이전부터 전하여 내려오는 습관. 
(기성세대) 현재 사회를 이끌어 가는 나이가 든 세대. 
(매양) [부사] 매 때마다. 
(담론) 이야기를 주고받으며 논의함. 
(견지) 어떤 사물을 판단하거나 관찰하는 입장. 
(제언) 의견이나 생각을 내놓음. 또는 그 의견이나 생각. 
(상설) (주로 일부 명사 앞에 쓰여) 언제든지 이용할 수 있도록 설비와 시설을 갖추어 둠. 
(창건) 건물이나 조직체 따위를 처음으로 세우거나 만듦. 
(준거) 사물의 정도나 성격 따위를 알기 위한 근거나 기준.
(도야) (1) 도기를 만드는 일과 쇠를 주조하는 일. 또는 그런 일을 하는 사람. (2) 훌륭한 사람이 되도록 몸과 마음을 닦아 기름을 비유적으로 이르는 말
(집정) (1) 정권을 잡음. (2) 정권을 잡고 있는 사람. 
*/

int bar=100;//프로그래스
int cout=0;//점수
int ran=0;
boolean end=false;
    /**
     * Creates new form game2P
     * @param end
     */
    public kor_game_menu() {
        
        initComponents();
        try {
            im=ImageIO.read(Menu.class.getResource("10.png"));
           
        } catch (IOException ex) {
            Logger.getLogger(codin_menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        repaint();//페인트 업데이트
        Thread th=new Thread(new Runnable() {
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
       Thread tt=new Thread(new Runnable() {
           //프로그래스바
            @Override
            public void run() {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.                
                for (int i = 0; i < 100; i++) { 
                    if(end)
                        return;
                    try {
                        Thread.sleep(1000);//1초마다 감소 하도록
                    } catch (InterruptedException ex) {
                        Logger.getLogger(game2P.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println(ex);
                    }
                    --bar;
                   jProgressBar1.setValue(bar);//프로그래스바 출력
                   if(bar==0){
                      not_victory v=new not_victory();//시간이 끝나면 창 출력
                       victory vic=new victory();
                       if(cout>5){
                           vic.cout=cout;
                           vic.Gname="한글게임";
                           vic.setVisible(true);
                       }else{
                           v.setVisible(true);
                       }
                       
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(game2P.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        new kor_Game().dispose();
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
        g.drawImage(im, 0, -20, 900 , 582, this);
        
          int b = 1;
          g.drawString(st[ran], numX,300);
         
          
            int ii=1;     
            for (int i = 1; i < st.length; i++) {
                
                ii++;
                int a=20*ii;
                b=numX+(100*i);
                try {
                  
                g.drawString(st[i],b, a);
              } catch (Exception e) {
                    System.out.println(e);
              }
                if(350<a){
                    ii=1;
                }
            }
              if(b<-50)
                numX=700;
        
          
          
          
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
    void count(){
        jLabel1.setText("점수 : "+cout);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)))
                .addContainerGap())
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
        Thread th=new Thread(new Runnable() {
            @Override
            public void run() {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                while (true) {                    
                    
               
                for (int i = 0; i < st.length; i++) {
                    //같은 단어를 입력하면 단어를 없에고 소리를 추력
                    String ss=jTextField1.getText();
                    if(ss.equals(st[i])){
                        jTextField1.setText("");//엔터키를 누르면 초기화
                        st[i]="  ";
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
