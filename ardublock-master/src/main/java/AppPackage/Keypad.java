/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AppPackage;


public class Keypad {
    int id;
    char Port;
    int x_axis=50;
    int y_axis=50;

    public Keypad() {
    }

    public Keypad(int id, char Port) {
        this.id = id;
        this.Port = Port;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getPort() {
        return Port;
    }

    public void setPort(char Port) {
        this.Port = Port;
    }

    public int getX_axis() {
        return x_axis;
    }

    public void setX_axis(int x_axis) {
        this.x_axis = x_axis;
    }

    public int getY_axis() {
        return y_axis;
    }

    public void setY_axis(int y_axis) {
        this.y_axis = y_axis;
    }
    public String generatecode()
    {
        ////Keypad_Init(); this function use global variable for setting 
        //////////Keypad_Init 
        //////Keypad_Key_Press 
        //////Keypad_Key_Click 
        return "/*--------------- Keypad initialize -------------------- */\n"
                + "char keypadPort at PORT"+getPort()+";\n"
                +"/*------------ End of Keypad setting------------------ */\n";
        
    }
}
