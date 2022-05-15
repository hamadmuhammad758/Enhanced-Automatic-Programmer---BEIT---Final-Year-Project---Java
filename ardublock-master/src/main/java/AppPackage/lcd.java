/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppPackage;

/**
 *
 * @author Malikkamran
 */
public class lcd {
    int id;
    int mode;
    char data_port;
    char control_port;
    int E;
    int RS;
    int []pin;
    int x_axis;
    int y_axis;
    void lcd()
    {
        pin=new int[8];
        x_axis=50;
        y_axis=50;
        mode=8;
        
    }

    public int getId() {
        return id;
    }

    public int getMode() {
        return mode;
    }

    public char getData_port() {
        return data_port;
    }

    public char getControl_port() {
        return control_port;
    }

    public int getE() {
        return E;
    }

    public int getRS() {
        return RS;
    }

    public int[] getPin() {
        return pin;
    }

    public int getX_axis() {
        return x_axis;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public void setData_port(char data_port) {
        this.data_port = data_port;
    }

    public void setControl_port(char control_port) {
        this.control_port = control_port;
    }

    public void setE(int E) {
        this.E = E;
    }

    public void setRS(int RS) {
        this.RS = RS;
    }

    public void setPin(int[] pin) {
        this.pin = pin;
    }

    public void setX_axis(int x_axis) {
        this.x_axis = x_axis;
    }

    public void setY_axis(int y_axis) {
        this.y_axis = y_axis;
    }

    public int getY_axis() {
        return y_axis;
    }
    String Setting8()
    {
        String code="/*-----LCD Setting---------*/\n";
        code+="sbit LCD_RS at R"+this.control_port+this.RS+"_bit;\n"
             +"sbit LCD_EN at R"+this.control_port+this.E+"_bit;\n";
        
        for(int a=0;a<8;a++)
        {
            code+="sbit LCD_D"+a+" at R"+this.data_port+a+"_bit;\n";
        }
        code+="sbit LCD_RS_Direction at TRIS"+this.control_port+this.RS+"_bit;\n"
             +"sbit LCD_EN_Direction at TRIS"+this.control_port+this.E+"_bit;\n";
        for(int a=0;a<8;a++)
        {
            code+="sbit LCD_D"+a+"_Direction at TRIS"+this.data_port+a+"_bit;\n";
        }
        code+="/*------------LCD Setting Ends */\n";
        return code;
    
    }
    void Setting4()
    {
    
    }
}
