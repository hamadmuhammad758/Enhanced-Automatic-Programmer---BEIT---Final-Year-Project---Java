

package AppPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

public class PanelFrontEndView extends JPanel implements MouseListener, MouseMotionListener{
  
    JPopupMenu ledpopup,stepperPopup,lcdPopup,keyPopup,segmentPopup,tempPopup; 
    String deviceName;
    JMenuItem ledDrag,ledProperties,ledRemove;
    JMenuItem lcdDrag,lcdProperties,lcdRemove;
    JMenuItem keyDrag,keyProperties,keyRemove;
    JMenuItem tempDrag,tempProperties,tempRemove;
    JMenuItem segmentDrag,segmentProperties,segmentRemove;
    JMenuItem stepperDrag,stepperProperties,stepperRemove;
    private int squareX = 250;
    private int squareY = 250; 
    private int MicroX=450;
    private int MicroY=100;
    private BufferedImage img1;
    private String device_right_clicked;
    static String code_4_main="";
    private boolean drawNewOnMouseMove;
    ArrayList<led> leds=new ArrayList<led>();
    ArrayList<lcd> lcds=new ArrayList<lcd>();
    ArrayList<TempSensor> Tsensors=new ArrayList<TempSensor>();
    ArrayList<SevenSegment> segments=new ArrayList<SevenSegment>();
    ArrayList<stepperMotor> steppers=new ArrayList<stepperMotor>();
    ArrayList<Keypad> keypads=new ArrayList<Keypad>();
    public  ArrayList<Object> components=new ArrayList<Object>();
    private led l;
    private lcd lc;
    private stepperMotor sm;
    private TempSensor tempSense;
    private SevenSegment seg;
    private Keypad key;
    private BufferedImage ledImg,TempSenseImg,SevenSegmentImg,KeypadImg,stepImg,lcdImg;
    private int currentIndex;    
    int [] PORTA=new int[8];   
    int [] PORTB=new int[8];   
    int [] PORTC=new int[8];   
    int [] PORTD=new int[8];
    Object [] PORTsA=new Object[8];
    Object [] PORTsB=new Object[8];
    Object [] PORTsC=new Object[8];
    Object [] PORTsD=new Object[8];
    
    int portACordinates=198,portBCordinates=328;
    int portCCordinates=149,portDCordinates=296;
    BufferedWriter bw=null;
    BufferedReader br=null;
    File file=null;
    
    
    
    public PanelFrontEndView() {
        setBorder(BorderFactory.createLineBorder(Color.black));
       
        setPopupmenus();
        setBackground(Color.white);
        addMouseListener(this);
        addMouseMotionListener(this);
        setBounds(0,0,1200,700);
        deviceName="none";
          try {
             file =new File("code.txt");
           
    		if(!file.exists()){
    			file.createNewFile();
                        bw = new BufferedWriter(new FileWriter(file.getName(),true));
                        bw.write("void Main()\n{"
                                + "\n\tsetting();\n"
                                + "\twhile(1)\n\t{\n"
                                + "\n\t}\n}");
                        bw.flush();
                }
        }catch(Exception e)
        {
            System.out.println("exception");
        } 
        for(int i=0 ; i<8 ; i++){
            PORTA[i]=PORTB[i]=PORTC[i]=PORTD[i]=-1;
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
         if(drawNewOnMouseMove){
             drawNewOnMouseMove=false;
         }
    }
    public void removeTempSensorOrLed(char po,int bi){
                         switch(po){
                             case 'A':
                                 PORTA[bi]=-1;
                                 PORTsA[bi]=null;
                                 break;
                             case 'B':
                                 PORTB[bi]=-1;
                                 PORTsB[bi]=null;
                                 break;
                             case 'C':
                                 PORTC[bi]=-1;
                                 PORTsC[bi]=null;
                                 break;
                             case 'D':
                                 PORTD[bi]=-1;
                                 PORTsD[bi]=null;
                                 break;
                         }
    }
    public void removeKeypadOrSevenSegment(char aa){
        switch(aa){
                             case 'A':
                                 for (int i = 0; i <7; i++) {                                     
                                    PORTA[i]=-1;
                                    PORTsA[i]=null;
                                 }
                                 break;
                             case 'B':
                                 for (int i = 0; i <7; i++) {                                     
                                    PORTB[i]=-1;
                                    PORTsB[i]=null;
                                 }
                                 break;
                             case 'C':
                                 for (int i = 0; i <7; i++) {                                     
                                    PORTC[i]=-1;
                                    PORTsC[i]=null;
                                 }
                                 break;
                             case 'D':
                                 for (int i = 0; i <7; i++) {                                     
                                    PORTD[i]=-1;
                                    PORTsD[i]=null;
                                 }
                                 break;
                         }
    }
    public void removeStepper(){
        stepperMotor ll=steppers.get(currentIndex);
        components.remove(ll);
        int [] pins=ll.getpins();
             switch((ll.getPort()+"")) {
               case "A":
                   for(int a=0;a<4;a++)
                    {
                        PORTA[pins[a]]=-1;
                        PORTsA[pins[a]]=null;
                    }
                   break;
               case "B":
                   for(int a=0;a<4;a++)
                    {
                        PORTB[pins[a]]=-1;
                        PORTsB[pins[a]]=null;
                    }
                   break;
               case "C":
                   for(int a=0;a<4;a++)
                    {
                        PORTC[pins[a]]=-1;
                        PORTsC[pins[a]]=null;
                    }
                   break;
               case "D":
                   for(int a=0;a<4;a++)
                    {
                        PORTD[pins[a]]=-1;
                        PORTsD[pins[a]]=null;
                    }
                   break;
           } 
             
        steppers.remove(currentIndex);
    }
    public void removeLcd(){
        lcd l=lcds.get(currentIndex);
        components.remove(l);
          if(l.getMode()==8)
            {   
                switch((l.getData_port()+"")){
                    case "A":
                        for(int a=0;a<7;a++)
                        {
                            PORTA[a]=-1;
                            PORTsA[a]=null;
                        }
                        break;
                    case "B":
                        for(int a=0;a<7;a++)
                        {
                            PORTB[a]=-1;
                            PORTsB[a]=null;
                        }
                        break;
                    case "C":
                        for(int a=0;a<7;a++)
                        {
                            PORTC[a]=-1;
                            PORTsC[a]=null;
                        }
                        break;
                    case "D":
                        for(int a=0;a<7;a++)
                        {
                            PORTD[a]=-1;
                            PORTsD[a]=null;
                        }
                        break;
                }
               switch((l.getControl_port()+"")){
                   case "A":
                       PORTA[l.getE()]=-1;
                       PORTsA[l.getE()]=null;
                       PORTA[l.getRS()]=-1;
                       PORTsA[l.getRS()]=null;
                      break; 
                   case "B":
                       PORTB[l.getE()]=-1;
                       PORTsB[l.getE()]=null;
                       PORTB[l.getRS()]=-1;
                       PORTsB[l.getRS()]=null;
                      break; 
                   case "C":
                       PORTC[l.getE()]=-1;
                       PORTsC[l.getE()]=null;
                       PORTC[l.getRS()]=-1;
                       PORTsC[l.getRS()]=null;
                      break; 
                   case "D":
                       PORTD[l.getE()]=-1;
                       PORTsD[l.getE()]=null;
                       PORTD[l.getRS()]=-1;
                       PORTsD[l.getRS()]=null;
                      break;     
               }
            }
          lcds.remove(currentIndex);
        
    }
    @Override
    public void mousePressed(MouseEvent e) {
                  try {
                     JMenuItem jm=(JMenuItem)e.getSource();
                      System.out.println("Menu text : " + jm.getText());
                     if((jm.getText()).equals("Remove Led")){
                         JOptionPane.showConfirmDialog(ledpopup,"Are You Sure To Remove :"+leds.size());                         
                         led ll=leds.get(currentIndex);
                         removeTempSensorOrLed(ll.getPort(),ll.getBitNo());
                         leds.remove(currentIndex);
                         components.remove(ll);
                         repaint();
                     }if((jm.getText()).equals("Remove Seven Segment")){
                         JOptionPane.showConfirmDialog(ledpopup,"Are You Sure To Remove :"+leds.size());
                         SevenSegment ll=segments.get(currentIndex);
                         removeKeypadOrSevenSegment(ll.getPort());
                         segments.remove(currentIndex);
                         components.remove(ll);
                         repaint();
                     }else if((jm.getText()).equals("Remove Keypad")){
                         JOptionPane.showConfirmDialog(ledpopup,"Are You Sure To Remove :"+leds.size());
                         Keypad ll=keypads.get(currentIndex);
                         removeKeypadOrSevenSegment(ll.getPort());
                         keypads.remove(currentIndex);
                         components.remove(ll);
                         repaint();
                     }else if((jm.getText()).equals("Remove Stepper")){
                         JOptionPane.showConfirmDialog(ledpopup,"Are You Sure To Remove :"+leds.size());
                         removeStepper();
                         
                         repaint();
                     }else if((jm.getText()).equals("Remove Temperature Sensor")){
                         JOptionPane.showConfirmDialog(ledpopup,"Are You Sure To Remove :"+leds.size());                        
                         TempSensor ll=Tsensors.get(currentIndex);
                         removeTempSensorOrLed(ll.getPort(),ll.getBitNo());
                         Tsensors.remove(currentIndex);
                         components.remove(ll);
                         repaint();
                     }else if((jm.getText()).equals("Remove Lcd")){
                         JOptionPane.showConfirmDialog(ledpopup,"Are You Sure To Remove :"+leds.size());                        
                         removeLcd();
                         repaint();
                     }       
                     else if((jm.getText()).equals("Set Led properties")){
                        setLedProperties g=new setLedProperties(new Main_Menu(),true,leds.get(currentIndex),this,PORTA,PORTB,PORTC,PORTD);
                        g.show();
                     }else if((jm.getText()).equals("Drag led")){
                        l=leds.get(currentIndex);
                        deviceName="led";
                        drawNewOnMouseMove=true;
                    }else if((jm.getText()).equals("Drag Stepper")){
                        sm=steppers.get(currentIndex);
                        deviceName="Stepper";
                        drawNewOnMouseMove=true;
                     }else if((jm.getText()).equals("Drag lcd")){
                        lc=lcds.get(currentIndex);
                        deviceName="lcd";
                        drawNewOnMouseMove=true;
                     }else if((jm.getText()).equals("Drag Keypad")){
                        key=keypads.get(currentIndex);
                        deviceName="Keypad";
                        drawNewOnMouseMove=true;
                     }else if((jm.getText()).equals("Drag Temperature Sensor")){
                        tempSense=Tsensors.get(currentIndex);
                        deviceName="Temperature Sensor";
                        drawNewOnMouseMove=true;
                     }else if((jm.getText()).equals("Drag Seven Segment")){
                        seg=segments.get(currentIndex);
                        deviceName="Seven Segment";
                        drawNewOnMouseMove=true;
                     }
                     else if((jm.getText()).equals("Set Lcd properties")){
                        setLcdProperties slp=new setLcdProperties(new Main_Menu(),true,lcds.get(currentIndex),this,PORTA,PORTB,PORTC,PORTD);
                        slp.show();
                     }else if((jm.getText()).equals("Set Stepper properties")){
                        setStepperProperties ssp=new setStepperProperties(new Main_Menu(),true,steppers.get(currentIndex),this,PORTA,PORTB,PORTC,PORTD);
                        ssp.show();
                     }else if((jm.getText()).equals("Set Keypad properties")){
                        setKeypadProperties skp= new setKeypadProperties(new Main_Menu(),true,keypads.get(currentIndex),this,PORTA,PORTB,PORTC,PORTD);
                        skp.show();
                     }else if((jm.getText()).equals("Set Temperature Sensor properties")){
                        setTempSensorProperties st=new setTempSensorProperties(new Main_Menu(),true,Tsensors.get(currentIndex),this,PORTA,PORTB,PORTC,PORTD);
                        st.show();
                     }else if((jm.getText()).equals("Set Seven Segment properties")){
                        setSevenSegmentProperties sssp=new setSevenSegmentProperties(new Main_Menu(),true,segments.get(currentIndex),this,PORTA,PORTB,PORTC,PORTD);
                        sssp.show();
                     }
                    }catch (Exception ee) {
                        //System.out.println("Menu ka item click nae hua");
                 }
            
    }

    @Override
    public void mouseReleased(MouseEvent e) {
      
        for (int i = 0; i < leds.size(); i++) {
            led a=leds.get(i);
            int squareX=a.getX_axis();
            int squareY=a.getY_axis();
            
             if(e.getX()>squareX && (squareX+ledImg.getWidth())>e.getX()){
             if(e.getY()>squareY && (squareY+ledImg.getHeight())>e.getY())
             {
                 if (e.isPopupTrigger()) {
                    ledpopup.show(e.getComponent(),e.getX(), e.getY());
                    currentIndex=i;
                    device_right_clicked="ledrightClicked";
                 }
             }    
           }
        }
        
        for (int i = 0; i < steppers.size(); i++) {
            stepperMotor a=steppers.get(i);
            int squareX=a.getX_axis();
            int squareY=a.getY_axis();
      //  JOptionPane.showMessageDialog(null,"squareX : "+squareX+" : squarey : "+squareY);
             if(e.getX()>squareX && (squareX+stepImg.getWidth())>e.getX()){
             if(e.getY()>squareY && (squareY+stepImg.getHeight())>e.getY())
             {
                 if (e.isPopupTrigger()) {
                    stepperPopup.show(e.getComponent(),e.getX(), e.getY());
                    currentIndex=i;
                    device_right_clicked="stepperrightClicked";
                 }
             }    
           }
        }   
        for (int i = 0; i < lcds.size(); i++) {
            lcd a=lcds.get(i);
            int squareX=a.getX_axis();
            int squareY=a.getY_axis();
      //  JOptionPane.showMessageDialog(null,"squareX : "+squareX+" : squarey : "+squareY);
             if(e.getX()>squareX && (squareX+lcdImg.getWidth())>e.getX()){
             if(e.getY()>squareY && (squareY+lcdImg.getHeight())>e.getY())
             {
                 if (e.isPopupTrigger()) {
                    lcdPopup.show(e.getComponent(),e.getX(), e.getY());
                    currentIndex=i;
                    device_right_clicked="lcdrightClicked";
                 }
             }    
           }
        }
          
        for (int i = 0; i < segments.size(); i++) {
            SevenSegment a=segments.get(i);
            int squareX=a.getX_axis();
            int squareY=a.getY_axis();
      //  JOptionPane.showMessageDialog(null,"squareX : "+squareX+" : squarey : "+squareY);
             if(e.getX()>squareX && (squareX+SevenSegmentImg.getWidth())>e.getX()){
             if(e.getY()>squareY && (squareY+SevenSegmentImg.getHeight())>e.getY())
             {
                 if (e.isPopupTrigger()) {
                    segmentPopup.show(e.getComponent(),e.getX(), e.getY());
                    currentIndex=i;
                    device_right_clicked="SevenSegmentrightClicked";
                 }
             }    
           }
        }
        
        for (int i = 0; i < Tsensors.size(); i++) {
            TempSensor a=Tsensors.get(i);
            int squareX=a.getX_axis();
            int squareY=a.getY_axis();
      //  JOptionPane.showMessageDialog(null,"squareX : "+squareX+" : squarey : "+squareY);
             if(e.getX()>squareX && (squareX+TempSenseImg.getWidth())>e.getX()){
             if(e.getY()>squareY && (squareY+TempSenseImg.getHeight())>e.getY())
             {
                 if (e.isPopupTrigger()) {
                    tempPopup.show(e.getComponent(),e.getX(), e.getY());
                    currentIndex=i;
                    device_right_clicked="TempSensorrightClicked";
                 }
             }    
           }
        }
        
        for (int i = 0; i < keypads.size(); i++) {
            Keypad a=keypads.get(i);
            int squareX=a.getX_axis();
            int squareY=a.getY_axis();
      //  JOptionPane.showMessageDialog(null,"squareX : "+squareX+" : squarey : "+squareY);
             if(e.getX()>squareX && (squareX+KeypadImg.getWidth())>e.getX()){
             if(e.getY()>squareY && (squareY+KeypadImg.getHeight())>e.getY())
             {
                 if (e.isPopupTrigger()) {
                    keyPopup.show(e.getComponent(),e.getX(), e.getY());
                    currentIndex=i;
                    device_right_clicked="keypadrightClicked";
                 }
             }    
           }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    //    System.out.println("Entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
    //    System.out.println("Exited");
   
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //System.out.println("Dragged : x : "+e.getX()+" : y : "+e.getY()); 
        if(e.getX()>0 && e.getY()>0 && e.getX()<903 )
            moveSquare(e.getX(),e.getY());
        else
            JOptionPane.showMessageDialog(ledpopup,"Outside of Range");
    }
    @Override
    public void mouseMoved(MouseEvent e) {
    
        if(drawNewOnMouseMove){
            if(deviceName=="led")
            {
                l.setX_axis(e.getX());
                l.setY_axis(e.getY());
                moveSquare(e.getX(),e.getY());
            }
            else if(deviceName.equals("lcd"))
            {
                lc.setX_axis(e.getX());
                lc.setY_axis(e.getY());
                moveSquare(e.getX(),e.getY());
            }
            else if(deviceName.equals("Stepper")){
                
                sm.setX_axis(e.getX());
                sm.setY_axis(e.getY());
                moveSquare(e.getX(),e.getY());
            }
            else if(deviceName.equals("Keypad")){
                
                key.setX_axis(e.getX());
                key.setY_axis(e.getY());
                moveSquare(e.getX(),e.getY());
            }
            else if(deviceName.equals("Temperature Sensor")){
                
                tempSense.setX_axis(e.getX());
                tempSense.setY_axis(e.getY());
                moveSquare(e.getX(),e.getY());
            }
            else if(deviceName.equals("Seven Segment")){
                
                seg.setX_axis(e.getX());
                seg.setY_axis(e.getY());
                moveSquare(e.getX(),e.getY());
            }
        }
    }     
    private void moveSquare(int x, int y) {
        squareX=x;
        squareY=y;
        repaint();
    }   
    public Dimension getPreferredSize() {
        return new Dimension(250,200);
    }
    public void makeComponenetsArrayList(){
        components.clear();
        JOptionPane.showMessageDialog(null, leds.size());
        for (int i = 0; i < leds.size(); i++){components.add(leds.get(i));}
        for (int i = 0; i < lcds.size(); i++){components.add(lcds.get(i)); }
        for (int i = 0; i < steppers.size(); i++){components.add(steppers.get(i));}
        for (int i = 0; i < segments.size(); i++){components.add(segments.get(i));}
        for (int i = 0; i < Tsensors.size(); i++) {components.add(Tsensors.get(i));}
        for (int i = 0; i < keypads.size(); i++) {components.add(keypads.get(i));}
       
   }
    void generatecode()    {
        makeComponenetsArrayList();
        Object comp=new Object();
        String setting="void setting()\n{\n";
        String led="",lcd="",keypad="",seven="",stepper="";
        int leed=0,motorr=0,sevenn=0;
        String function="",main="void Main()\n{"
                                + "\n\tsetting();\n"
                                + "\twhile(1)\n\t{\n"
                                + "\n\t}\n}";
        String integration="";
       
        for(int z=0;z<components.size();z++)
        {
            comp=components.get(z);
            if((comp instanceof led)&&(leed==0))
            {
                setting+="    led_setting();\n";
                leed=1;
            }else if((comp instanceof stepperMotor)&&(motorr==0))
            {
                setting+="    stepper_setting();\n";
                motorr=1;
            }else if((comp instanceof SevenSegment)&&(sevenn==0))
            {
                setting+="    sevensegment_setting();\n";
                sevenn=1;
            }
        }
        setting+="\n}\n";
        
        for(int a=0;a<components.size();a++){
            comp=components.get(a);
            System.out.println(comp);
            if(comp instanceof led)
            {
                led l=(led)comp;
                led+=l.Setting();
            }
            else if(comp instanceof lcd)
            {
                lcd l=(lcd)comp;
                lcd+=l.Setting8();
            }else if(comp instanceof Keypad)
            {
                Keypad l=(Keypad)comp;
                keypad+=l.generatecode();
            }
            else if(comp instanceof stepperMotor)
            {
                stepperMotor l=(stepperMotor)comp;
                stepper+=l.generatecode();
            }
            else if(comp instanceof SevenSegment)
            {
                SevenSegment l=(SevenSegment)comp;
                seven+=l.generatecode();
            }
            
        }
        
        leed=0;motorr=0;sevenn=0;
        for(int a=0;a<components.size();a++){
            comp=components.get(a);
            System.out.println(comp);
            if((comp instanceof led)&&(leed==0))
            {
                function="void led_setting()\n"
            + "{"
                    +led
            + "}";
                integration+="\n"+function;
                leed=1;
            }
            else if((comp instanceof stepperMotor)&&(motorr==0))
            {
                function="void stepper_setting()\n"
                + "{"
                    +stepper
                + "}";
                integration+="\n"+function;
                motorr=1;
            }
            else if((comp instanceof SevenSegment)&&(sevenn==0))
            {
                function="void sevensegment_setting()\n"
            + "{"
                + seven
            + "}";
                integration+="\n"+function;
                sevenn=1;
            }
            else if(comp instanceof lcd)
            {
                integration+="\n"+lcd;
            }else if(comp instanceof Keypad)
            {
                integration+="\n"+keypad;
                
            }
            
            
        }
        printcode(integration+setting+main);
    }
    void setcomponent(Object comp,Object old){
        
         if(comp instanceof TempSensor)
        {
            TempSensor l=(TempSensor)comp;
            TempSensor older=(TempSensor)old;
        //    components.remove(old);
          //  components.add(l);
            switch((older.getPort()+"")){
                   case "A":
                    PORTA[older.getBitNo()]=-1;
                    PORTsA[older.getBitNo()]=null;
                       break;
                   case "B":
                    PORTB[older.getBitNo()]=-1;
                    PORTsB[older.getBitNo()]=null;
                       break;
                   case "C":
                    PORTC[older.getBitNo()]=-1;
                    PORTsC[older.getBitNo()]=null;
                       break;
                   case "D":
                    PORTD[older.getBitNo()]=-1;
                    PORTsD[older.getBitNo()]=null;
                       break;
            }  
             switch((l.getPort()+"")){
                   case "A":
                    PORTA[l.getBitNo()]=0;
                    PORTsA[l.getBitNo()]=l;
                       break;
                   case "B":
                    PORTB[l.getBitNo()]=0;
                    PORTsB[l.getBitNo()]=l;
                       break;
                   case "C":
                    PORTC[l.getBitNo()]=0;
                    PORTsC[l.getBitNo()]=l;
                       break;
                   case "D":
                    PORTD[l.getBitNo()]=0;
                    PORTsD[l.getBitNo()]=l;
                       break;
            } 
        }
        else if(comp instanceof led)
        {
            
            led l=(led)comp;
            led older=(led)old;
            
            //components.add(l);
            
            switch((older.getPort()+"")){
                   case "A":
                    PORTA[older.getBitNo()]=-1;
                    PORTsA[older.getBitNo()]=null;
                       break;
                   case "B":
                    PORTB[older.getBitNo()]=-1;
                    PORTsB[older.getBitNo()]=null;
                       break;
                   case "C":
                    PORTC[older.getBitNo()]=-1;
                    PORTsC[older.getBitNo()]=null;
                       break;
                   case "D":
                    PORTD[older.getBitNo()]=-1;
                    PORTsD[older.getBitNo()]=null;
                       break;
            }  
             switch((l.getPort()+"")){
                   case "A":
                    PORTA[l.getBitNo()]=0;
                    PORTsA[l.getBitNo()]=l;
                       break;
                   case "B":
                    PORTB[l.getBitNo()]=0;
                    PORTsB[l.getBitNo()]=l;
                       break;
                   case "C":
                    PORTC[l.getBitNo()]=0;
                    PORTsC[l.getBitNo()]=l;
                       break;
                   case "D":
                    PORTD[l.getBitNo()]=0;
                    PORTsD[l.getBitNo()]=l;
                       break;
            } 
        }
        else if(comp instanceof lcd)
        {
        lcd l=(lcd)comp;
        lcd older=(lcd)old;
        //components.remove(old);
        //components.add(l);
            if(l.getMode()==8)
            {   
                switch((older.getData_port()+"")){
                    case "A":
                        for(int a=0;a<7;a++)
                        {
                            PORTA[a]=-1;
                            PORTsA[a]=null;
                        }
                        break;
                    case "B":
                        for(int a=0;a<7;a++)
                        {
                            PORTB[a]=-1;
                            PORTsB[a]=null;
                        }
                        break;
                    case "C":
                        for(int a=0;a<7;a++)
                        {
                            PORTC[a]=-1;
                            PORTsC[a]=null;
                        }
                        break;
                    case "D":
                        for(int a=0;a<7;a++)
                        {
                            PORTD[a]=-1;
                            PORTsD[a]=null;
                        }
                        break;
                }
               switch((older.getControl_port()+"")){
                   case "A":
                       PORTA[older.getE()]=-1;
                       PORTsA[older.getE()]=null;
                       PORTA[older.getRS()]=-1;
                       PORTsA[older.getRS()]=null;
                      break; 
                   case "B":
                       PORTB[older.getE()]=-1;
                       PORTsB[older.getE()]=null;
                       PORTB[older.getRS()]=-1;
                       PORTsB[older.getRS()]=null;
                      break; 
                   case "C":
                       PORTC[older.getE()]=-1;
                       PORTsC[older.getE()]=null;
                       PORTC[older.getRS()]=-1;
                       PORTsC[older.getRS()]=null;
                      break; 
                   case "D":
                       PORTD[older.getE()]=-1;
                       PORTsD[older.getE()]=null;
                       PORTD[older.getRS()]=-1;
                       PORTsD[older.getRS()]=null;
                      break;     
               }
                switch((l.getData_port()+"")){
                    case "A":
                        for(int a=0;a<7;a++)
                        {
                            PORTA[a]=0;
                            PORTsA[a]=l;
                        }
                        break;
                    case "B":
                        for(int a=0;a<7;a++)
                        {
                            PORTB[a]=0;
                            PORTsB[a]=l;
                        }
                        break;
                    case "C":
                        for(int a=0;a<7;a++)
                        {
                            PORTC[a]=0;
                            PORTsC[a]=l;
                        }
                        break;
                    case "D":
                        for(int a=0;a<7;a++)
                        {
                            PORTD[a]=0;
                            PORTsD[a]=l;
                        }
                        break;
                }
               switch((l.getControl_port()+"")){
                   case "A":
                       PORTA[l.getE()]=0;
                       PORTsA[l.getE()]=1;
                       PORTA[l.getRS()]=0;
                       PORTsA[l.getRS()]=1;
                      break; 
                   case "B":
                       PORTB[l.getE()]=0;
                       PORTsB[l.getE()]=1;
                       PORTB[l.getRS()]=0;
                       PORTsB[l.getRS()]=1;
                      break; 
                   case "C":
                       PORTC[l.getE()]=0;
                       PORTsC[l.getE()]=1;
                       PORTC[l.getRS()]=0;
                       PORTsC[l.getRS()]=1;
                      break; 
                   case "D":
                       PORTD[l.getE()]=0;
                       PORTsD[l.getE()]=1;
                       PORTD[l.getRS()]=0;
                       PORTsD[l.getRS()]=1;
                      break;     
               }
            }   
        }else if(comp instanceof Keypad)
        {
           Keypad l=(Keypad)comp;
           Keypad older=(Keypad)old;
          // components.remove(old);
          // components.add(l);
          
             
           switch((older.getPort()+"")){
               case "A":
                   for(int a=0;a<7;a++)
                   {
                       PORTA[a]=-1;
                       PORTsA[a]=null;
                    }
                   break;
               case "B":
                   for(int a=0;a<7;a++)
                   {
                       PORTB[a]=-1;
                       PORTsB[a]=null;
                    }
                   break;
               case "C":
                   for(int a=0;a<7;a++)
                   {
                       PORTC[a]=-1;
                       PORTsC[a]=null;
                    }
                   break;
               case "D":
                   for(int a=0;a<7;a++)
                   {
                       PORTD[a]=-1;
                       PORTsD[a]=null;
                    }
                   break;
           }
           switch((l.getPort()+"")){
               case "A":
                   for(int a=0;a<7;a++)
                   {
                       PORTA[a]=0;
                       PORTsA[a]=1;
                    }
                   break;
               case "B":
                   for(int a=0;a<7;a++)
                   {
                       PORTB[a]=0;
                       PORTsB[a]=1;
                    }
                   break;
               case "C":
                   for(int a=0;a<7;a++)
                   {
                       PORTC[a]=0;
                       PORTsC[a]=1;
                    }
                   break;
               case "D":
                   for(int a=0;a<7;a++)
                   {
                       PORTD[a]=0;
                       PORTsD[a]=1;
                    }
                   break;
           }
          
        }else if(comp instanceof stepperMotor)
        {
            stepperMotor l=(stepperMotor)comp;
            stepperMotor older=(stepperMotor)old;
            //components.remove(old);
            //components.add(l);          
            int [] pins=older.getpins();
            switch((older.getPort()+"")) {
               case "A":
                   for(int a=0;a<4;a++)
                    {
                        PORTA[pins[a]]=-1;
                        PORTsA[pins[a]]=null;
                    }
                   break;
               case "B":
                   for(int a=0;a<4;a++)
                    {
                        PORTB[pins[a]]=-1;
                        PORTsB[pins[a]]=null;
                    }
                   break;
               case "C":
                   for(int a=0;a<4;a++)
                    {
                        PORTC[pins[a]]=-1;
                        PORTsC[pins[a]]=null;
                    }
                   break;
               case "D":
                   for(int a=0;a<4;a++)
                    {
                        PORTD[pins[a]]=-1;
                        PORTsD[pins[a]]=null;
                    }
                   break;
           } 
           pins=l.getpins();
           switch((l.getPort()+"")) {
               case "A":
                   for(int a=0;a<4;a++)
                    {
                        PORTA[pins[a]]=0;
                        PORTsA[pins[a]]=l;
                    }
                   break;
               case "B":
                   for(int a=0;a<4;a++)
                    {
                        PORTB[pins[a]]=0;
                        PORTsB[pins[a]]=l;
                    }
                   break;
               case "C":
                   for(int a=0;a<4;a++)
                    {
                        PORTC[pins[a]]=0;
                        PORTsC[pins[a]]=l;
                    }
                   break;
               case "D":
                   for(int a=0;a<4;a++)
                    {
                        PORTD[pins[a]]=0;
                        PORTsD[pins[a]]=l;
                    }
                   break;
           }
           
         
        }else if(comp instanceof SevenSegment)
        {
            SevenSegment l=(SevenSegment)comp;
            SevenSegment older=(SevenSegment)old;
            //components.remove(older);
            //components.add(l);
            
            switch((older.getPort()+"")){
                case "A":
                   for(int a=0;a<7;a++)
                   {
                       PORTA[a]=-1;
                       PORTsA[a]=null;
                   }
                    break;
                case "B":
                   for(int a=0;a<7;a++)
                   {
                       PORTB[a]=-1;
                       PORTsB[a]=null;
                   }
                    break;
                case "C":
                   for(int a=0;a<7;a++)
                   {
                       PORTC[a]=-1;
                       PORTsC[a]=null;
                   }
                    break;
                case "D":
                   for(int a=0;a<7;a++)
                   {
                       PORTD[a]=-1;
                       PORTsD[a]=null;
                   }
                    break;
            }
            
            switch((l.getPort()+"")){
                case "A":
                   for(int a=0;a<7;a++)
                   {
                       PORTA[a]=0;
                       PORTsA[a]=1;
                   }
                    break;
                case "B":
                   for(int a=0;a<7;a++)
                   {
                       PORTB[a]=0;
                       PORTsB[a]=1;
                   }
                    break;
                case "C":
                   for(int a=0;a<7;a++)
                   {
                       PORTC[a]=0;
                       PORTsC[a]=1;
                   }
                    break;
                case "D":
                   for(int a=0;a<7;a++)
                   {
                       PORTD[a]=0;
                       PORTsD[a]=1;
                   }
                    break;
            }
            
        }
        repaint();
    }    
   void setDrawingItem(String s){
        deviceName=s;
          if(deviceName.equals("led"))
          {
              
            l=new led();
            l.setId(leds.size());
            leds.add(l);    
            drawNewOnMouseMove=true;
            
          }else if(deviceName.equals("lcd"))
          {
              lc=new lcd();
              lc.setId(lcds.size());
              lcds.add(lc);
              drawNewOnMouseMove=true;
          }
          else if(deviceName.equals("Stepper"))
           {
            sm=new stepperMotor();
            sm.setId(steppers.size());
            steppers.add(sm);
            drawNewOnMouseMove=true;
           }
          else if(deviceName.equals("Keypad"))
          {
              key=new Keypad();
              key.setId(keypads.size());
              keypads.add(key);          
              drawNewOnMouseMove=true;
          }
          else if(deviceName.equals("Temperature Sensor"))
          {
              tempSense=new TempSensor();
              tempSense.setId(Tsensors.size());
              Tsensors.add(tempSense);            
              drawNewOnMouseMove=true;
          }
          else if(deviceName.equals("Seven Segment"))
          {
              seg=new SevenSegment();
              seg.setId(segments.size());
              segments.add(seg);          
              drawNewOnMouseMove=true;
          }
    }    
    void printcode(String code)    {
       
       String data=""; 
       String str="";
      code_4_main=code;
      
      try{
            
           InputStream is = new FileInputStream(file.getName());
        int size = is.available();
        for(int i=0; i< size; i++)
        {
          data=data+(char)is.read();
        }
        file.delete(); 
        file.createNewFile();
        bw = new BufferedWriter(new FileWriter(file.getName()));
        is.close();
        bw.write(code);
        bw.flush();
        bw.close();

       }
       catch(Exception ex)
        {
             System.out.println(ex);   
        }
       }
     protected void paintComponent(Graphics g) {     
        super.paintComponent(g);             
        try {
            img1 = ImageIO.read(new File("F:/Degree Project/Java Lib/AkhreeOqaat/ardublock-master/src/main/java/Drawable/Microcontroller.PNG"));           
            ledImg= ImageIO.read(new File("F:/Degree Project/Java Lib/AkhreeOqaat/ardublock-master/src/main/java/Drawable/led.PNG"));
            lcdImg= ImageIO.read(new File("F:/Degree Project/Java Lib/AkhreeOqaat/ardublock-master/src/main/java/Drawable/lcd16x2.PNG"));
            stepImg= ImageIO.read(new File("F:/Degree Project/Java Lib/AkhreeOqaat/ardublock-master/src/main/java/Drawable/stepperMottor.PNG"));
            TempSenseImg= ImageIO.read(new File("F:/Degree Project/Java Lib/AkhreeOqaat/ardublock-master/src/main/java/Drawable/tempSensor.PNG"));
            SevenSegmentImg= ImageIO.read(new File("F:/Degree Project/Java Lib/AkhreeOqaat/ardublock-master/src/main/java/Drawable/sevenSegment.PNG"));
            KeypadImg= ImageIO.read(new File("F:/Degree Project/Java Lib/AkhreeOqaat/ardublock-master/src/main/java/Drawable/keypad.PNG"));
  
        } catch (IOException e) {
           JOptionPane.showMessageDialog(this,"image nae milli");
        }
        for (int i = 0; i < leds.size(); i++) {
            led a=leds.get(i);
            g.drawImage(ledImg,a.getX_axis(),a.getY_axis(), this);
            g.drawString("Led "+(i+1),a.getX_axis()+5, a.getY_axis()-5);
            g.drawString(a.getPort()+"."+a.getBitNo(),a.getX_axis()+5, a.getY_axis()+5);
        }
        for (int i = 0; i < lcds.size(); i++) {
            lcd a=lcds.get(i);
            g.drawImage(lcdImg,a.getX_axis(),a.getY_axis(), this);
            if(a.getMode()==8){
                
                g.drawString("LCD "+(i+1),a.getX_axis()+lcdImg.getWidth()/2,a.getY_axis()-5);
                g.drawString(a.getControl_port()+"."+a.getE(),a.getX_axis()+70,a.getY_axis()+lcdImg.getHeight()+12);
                g.drawString(a.getControl_port()+"."+a.getRS(),a.getX_axis()+95,a.getY_axis()+lcdImg.getHeight()+12);
                g.drawString("PORT"+a.getData_port(),a.getX_axis()+135,a.getY_axis()+lcdImg.getHeight()+12);
            }
        }
        for (int i = 0; i < steppers.size(); i++) {
            stepperMotor a=steppers.get(i);
            g.drawImage(stepImg,a.getX_axis(),a.getY_axis(), this);
            g.drawString("Stepper "+(i+1),a.getX_axis()+(stepImg.getWidth()/2),a.getY_axis()-5);
            g.drawString(a.getPort()+"."+a.getpins()[0],a.getX_axis(),a.getY_axis()+15);
            g.drawString(a.getPort()+"."+a.getpins()[1],a.getX_axis(),a.getY_axis()+48);
            g.drawString(a.getPort()+"."+a.getpins()[2],a.getX_axis()+stepImg.getWidth()-10,a.getY_axis()+15);
            g.drawString(a.getPort()+"."+a.getpins()[3],a.getX_axis()+stepImg.getWidth()-10,a.getY_axis()+48);
        }
        for (int i = 0; i < segments.size(); i++) {
            SevenSegment a=segments.get(i);
            g.drawImage(SevenSegmentImg,a.getX_axis(),a.getY_axis(), this);
            g.drawString("Seven Segment "+(i+1),a.getX_axis()+SevenSegmentImg.getWidth()/2-20,a.getY_axis()-10);
            g.drawString("PORT"+a.getPort(),a.getX_axis()+SevenSegmentImg.getWidth()/2-20,a.getY_axis()+10);
        }
        for (int i = 0; i < Tsensors.size(); i++) {
            TempSensor a=Tsensors.get(i);
            g.drawImage(TempSenseImg,a.getX_axis(),a.getY_axis(), this);
            g.drawString("Temp Sensor "+(i+1),a.getX_axis()+TempSenseImg.getWidth()/2, a.getY_axis()-5);
             g.drawString(a.getPort()+"."+a.getBitNo(),a.getX_axis()+TempSenseImg.getWidth()-20, a.getY_axis()+TempSenseImg.getHeight()-60);
        }
        for (int i = 0; i < keypads.size(); i++) {
            Keypad a=keypads.get(i);
            g.drawImage(KeypadImg,a.getX_axis(),a.getY_axis(), this);
            g.drawString("Keypad "+(i+1),a.getX_axis()+KeypadImg.getWidth()/2-20,a.getY_axis()-10);
            g.drawString("PORT"+a.getPort(),a.getX_axis()+KeypadImg.getWidth()/2-20,a.getY_axis()+10);
        }
        g.drawImage(img1,MicroX,MicroY, this);
    
    } 
    public void setPopupmenus(){
       
        ledpopup = new JPopupMenu();
        ledRemove = new JMenuItem("Remove Led");
        ledRemove.addMouseListener(this);
        ledpopup.add(ledRemove);
        ledProperties = new JMenuItem("Set Led properties");
        ledProperties.addMouseListener(this);
        ledpopup.add(ledProperties);
        ledDrag = new JMenuItem("Drag led");
        ledDrag.addMouseListener(this);
        ledpopup.add(ledDrag);
        
        lcdPopup = new JPopupMenu();
        lcdRemove = new JMenuItem("Remove Lcd");
        lcdRemove.addMouseListener(this);
        lcdPopup.add(lcdRemove);
        lcdProperties = new JMenuItem("Set Lcd properties");
        lcdProperties.addMouseListener(this);
        lcdPopup.add(lcdProperties);
        lcdDrag = new JMenuItem("Drag lcd");
        lcdDrag.addMouseListener(this);
        lcdPopup.add(lcdDrag);
        
        keyPopup = new JPopupMenu();
        keyRemove = new JMenuItem("Remove Keypad");
        keyRemove.addMouseListener(this);
        keyPopup.add(keyRemove);
        keyProperties = new JMenuItem("Set Keypad properties");
        keyProperties.addMouseListener(this);
        keyPopup.add(keyProperties);
        keyDrag = new JMenuItem("Drag Keypad");
        keyDrag.addMouseListener(this);
        keyPopup.add(keyDrag);
        
        segmentPopup = new JPopupMenu();
        segmentRemove = new JMenuItem("Remove Seven Segment");
        segmentRemove.addMouseListener(this);
        segmentPopup.add(segmentRemove);
        segmentProperties = new JMenuItem("Set Seven Segment properties");
        segmentProperties.addMouseListener(this);
        segmentPopup.add(segmentProperties);
        segmentDrag = new JMenuItem("Drag Seven Segment");
        segmentDrag.addMouseListener(this);
        segmentPopup.add(segmentDrag);
        
        stepperPopup = new JPopupMenu();
        stepperRemove = new JMenuItem("Remove Stepper");
        stepperRemove.addMouseListener(this);
        stepperPopup.add(stepperRemove);
        stepperProperties = new JMenuItem("Set Stepper properties");
        stepperProperties.addMouseListener(this);
        stepperPopup.add(stepperProperties);
        stepperDrag = new JMenuItem("Drag Stepper");
        stepperDrag.addMouseListener(this);
        stepperPopup.add(stepperDrag);
        
        tempPopup = new JPopupMenu();
        tempRemove = new JMenuItem("Remove Temperature Sensor");
        tempRemove.addMouseListener(this);
        tempPopup.add(tempRemove);
        tempProperties = new JMenuItem("Set Temperature Sensor properties");
        tempProperties.addMouseListener(this);
        tempPopup.add(tempProperties);
        tempDrag = new JMenuItem("Drag Temperature Sensor");
        tempDrag.addMouseListener(this);
        tempPopup.add(tempDrag);
        
   }
}
