/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AppPackage;

/**
 *
 * @author hamad PC
 */
public class stepperMotor {
    int id;
    char port;
    int [] pins; // to connect 4 ports of stepper   
    int x_axis=50;
    int y_axis=50;
    
    public stepperMotor() {
        id=0;
        pins=new int[4];
        x_axis=y_axis=50;
        port='B';    
    }
    
    public stepperMotor(int id, char port, int[] arr) {
        this.id = id;
        this.port = port;
        this.pins = arr;
    }
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getX_axis() {
        return x_axis;
    }

    public int getY_axis() {
        return y_axis;
    }

    public void setX_axis(int x_axis) {
        this.x_axis = x_axis;
    }

    public void setY_axis(int y_axis) {
        this.y_axis = y_axis;
    } 
    public char getPort() {
        return port;
    }

    public void setPort(char port) {
        this.port = port;
    }

    public int[] getpins() {
        return pins;
    }

    public void setpins(int[] arr) {
        this.pins = arr;
    }
    
    public String generatecode()
    {
        String code="";
        code="    TRIS"+this.port+".B"+this.pins[0]+"=0;\n"
                + "    TRIS"+this.port+".B"+this.pins[1]+"=0;\n"
                + "    TRIS"+this.port+".B"+this.pins[2]+"=0;\n"
                + "    TRIS"+this.port+".B"+this.pins[3]+"=0;\n\n";
        return code;
    }
}
