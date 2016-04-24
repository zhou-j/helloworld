package cal;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;





public class CalcultorThree{
      
       JFrame frame;
       JButton buttonzero,buttondot,buttonequal;
       JButton buttonplus,buttonminus,buttonmultiple,buttondevision,
               buttonsin,buttontozero;
       JButton buttonone,buttontwo,buttonthree,buttonfour,buttonfive,
               buttonsix,buttonseven,buttoneight,buttonnine;
        JPanel panelwest,panelcenter,paneleast;
        TextField tf;
        public CalcultorThree(){
   
             tf=new TextField(30);
             frame = new JFrame("CalcultorThree");
             panelcenter= new JPanel();
             panelwest= new JPanel();
             paneleast= new JPanel();

             Handle h =new Handle();

             buttonone=new JButton("1");
             buttontwo=new JButton("2");
             buttonthree=new JButton("3");
             buttonfour=new JButton("4");
             buttonfive=new JButton("5");
             buttonsix=new JButton("6");
             buttonseven=new JButton("7");
             buttoneight=new JButton("8");
             buttonnine=new JButton("9");
             panelcenter.setLayout(new GridLayout(3,3));

             panelcenter.add(buttonone);
             panelcenter.add(buttontwo);
             panelcenter.add(buttonthree);
             panelcenter.add(buttonfour);
             panelcenter.add(buttonfive);
             panelcenter.add(buttonsix);
             panelcenter.add(buttonseven);
             panelcenter.add(buttoneight);
             panelcenter.add(buttonnine);

             buttonone.addActionListener(h);
             buttontwo.addActionListener(h);
             buttonthree.addActionListener(h);
             buttonfour.addActionListener(h);
             buttonfive.addActionListener(h);
             buttonsix.addActionListener(h);
             buttonseven.addActionListener(h);
             buttoneight.addActionListener(h);
             buttonnine.addActionListener(h);

             buttonzero=new JButton("0");
             buttondot=new JButton(".");
             buttonequal= new JButton("=");
             buttonzero.addActionListener(h);

             buttondot.addActionListener(h);
             buttonequal.addActionListener(h);
             panelwest.setLayout(new GridLayout(3,1));
             panelwest.add(buttonzero);
             panelwest.add(buttondot);
             panelwest.add(buttonequal);

             buttonplus=new JButton("+");
             buttonminus=new JButton("-");
             buttonmultiple=new JButton("*");
             buttondevision=new JButton("/");
             buttonsin=new JButton("sin");
             buttontozero=new JButton("->0");
             paneleast.setLayout(new GridLayout(3,1));
             paneleast.add(buttonplus);
             paneleast.add(buttonminus);
             paneleast.add(buttonmultiple);
             paneleast.add(buttondevision);
             paneleast.add(buttonsin);
             paneleast.add(buttontozero);

             buttonplus.addActionListener(h);
             buttonminus.addActionListener(h);
             buttonmultiple.addActionListener(h);
             buttondevision.addActionListener(h);
             buttonsin.addActionListener(h);
             buttontozero.addActionListener(h);

             
             frame.setLayout(new BorderLayout());
             frame.add(paneleast,"East");
             frame.add(tf,BorderLayout.NORTH);
             frame.add(panelwest,BorderLayout.WEST);
             frame.add(panelcenter,BorderLayout.CENTER);
             frame.pack();
             frame.setLocation(500,500);
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             frame.setVisible(true);
           }
           public static void main(String[] args){
                  new CalcultorThree();
           }
           class Handle implements ActionListener{
                 int biaozhi=0;
                 double flag1=0,flag2=0,flag3=0;
                 @Override
                 public void actionPerformed(ActionEvent e){
                     try{
                           if(e.getSource()==buttondot){
                               tf.setText("0.");
                            }
                            if(e.getSource()==buttontozero){
                                tf.setText("");
                             }
                                if(e.getSource()==buttonzero){
                                tf.setText(tf.getText()+"0");
                                flag1=Double.parseDouble(tf.getText()) ;
                              }
                                    else if(e.getSource()==buttonone){
                                   tf.setText(tf.getText()+"1");
                                   flag1=Double.parseDouble(tf.getText());
                               }  

                                   else if(e.getSource()==buttontwo){
                                   tf.setText(tf.getText()+"2");
                                   flag1=Double.parseDouble(tf.getText());
                               }
                                     else if(e.getSource()==buttonthree){
                                   tf.setText(tf.getText()+"3");
                                   flag1=Double.parseDouble(tf.getText());
                               }
                                       else if(e.getSource()==buttonfour){
                                   tf.setText(tf.getText()+"4");
                                   flag1=Double.parseDouble(tf.getText());
                               }
                                         else if(e.getSource()==buttonfive){
                                   tf.setText(tf.getText()+"5");
                                   flag1=Double.parseDouble(tf.getText());
                               } 
                                         else if(e.getSource()==buttonsix){
                                   tf.setText(tf.getText()+"6");
                                   flag1=Double.parseDouble(tf.getText());
                               }
                                          else if(e.getSource()==buttonseven){
                                   tf.setText(tf.getText()+"7");
                                   flag1=Double.parseDouble(tf.getText());
                               }
                                           else if(e.getSource()==buttoneight){
                                   tf.setText(tf.getText()+"8");
                                   flag1=Double.parseDouble(tf.getText());
                                   
                               }
                                            else if(e.getSource()==buttonnine){
                                   tf.setText(tf.getText()+"9");
                                   flag1=Double.parseDouble(tf.getText());
                               }
                                if(e.getSource()==buttonplus){
                                    tf.setText("");
                                    flag2=flag1;
                                    biaozhi=0;
                                 }
                                 if(e.getSource()==buttonminus){
                                    tf.setText("");
                                    flag2=flag1;
                                    biaozhi=1;
                                 }
                                 if(e.getSource()==buttonmultiple){
                                    tf.setText("");
                                    flag2=flag1;
                                    biaozhi=2;
                                 }
                                 if(e.getSource()==buttondevision){
                                    tf.setText("");
                                    flag2=flag1;
                                    biaozhi=3;
                                 }
                                 if(e.getSource()==buttonsin){
                                     flag3=Math.sin(flag1);
                                     tf.setText(flag3+"");
                                 }
                                 if(e.getSource()==buttonequal){
                                   if(biaozhi==0){
                                      flag3=flag1+flag2;
                                       }
                                   if(biaozhi==1){
                                      flag3=flag1-flag2;
                                       }
                                   if(biaozhi==2){
                                       flag3=flag1*flag2;
                                        }
                                    if(biaozhi==3){
                                        flag3=flag1/flag2;

                                        }
                                        tf.setText(flag3+"");
                                  }
                                      }catch(Exception ex){
                                        
                                        }

                                    }
                                    }


                                 }

           
         
 