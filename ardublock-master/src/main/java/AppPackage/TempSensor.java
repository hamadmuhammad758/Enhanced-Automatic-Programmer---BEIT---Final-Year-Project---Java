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
public class TempSensor { 
    int id;
    char port;
    int bitNo;
    int x_axis=50;
    int y_axis=50;
    
    public TempSensor() {
    }
    

    public TempSensor(char port, int bitNo) {
        this.port = port;
        this.bitNo = bitNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getPort() {
        return port;
    }

    public void setPort(char port) {
        this.port = port;
    }

    public int getBitNo() {
        return bitNo;
    }

    public void setBitNo(int bitNo) {
        this.bitNo = bitNo;
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

    
    
}
