
package move_ball;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
public class Move_ball {

   public static void main(String[] args) {
       new Move_ball();
       
   }
   public Move_ball(){
       EventQueue.invokeLater(new Runnable() {
           @Override
           public void run() {
               try{
                   UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
               }catch(ClassNotFoundException |InstantiationException |IllegalAccessException |UnsupportedLookAndFeelException  ex){
                   
               }
               
               JFrame frame =new JFrame("Testing");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setLayout(new BorderLayout());
               frame.add(new BallPane());
               frame.pack();
               frame.setLocationRelativeTo(null);
               frame.setVisible(true);
               
           }
       });
   }

   public class BallPane extends JPanel{
       int x1=(int )(Math.random()*10);
       int x2=(int )(Math.random()*10);
       int x3=(int )(Math.random()*10);
       int y1=(int )(Math.random()*10);
       int y2=(int )(Math.random()*10);
       int y3=(int )(Math.random()*10);

       int temp=0;
       
  public BallPane() {
       Timer timer; 
            timer = new Timer( 40, new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (y1 < getHeight()) {
                        y1 += 1;
                    } else {
                        ((Timer)e.getSource()).stop();
                    }
                    repaint();
                }
            });
            timer.start();
        }
       @Override 
       public Dimension getPreferredSize(){
           return new Dimension(200,200);
       }
       @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 200, 300);
            g.setColor(Color.PINK);
            g.fillOval(x1, y1, 15, 15);
//            g.setColor(Color.YELLOW);
//            g.fillOval(x2, y2, 15, 15);
//            g.setColor(Color.RED);
//            g.fillOval(x3, y3, 15, 15);
//            g.setColor(Color.RED);
//            g.fillArc(80, 230, 50, 30, 180, 180);
        }
       
   }
   
}