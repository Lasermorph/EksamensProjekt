/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.openjfx.javamessenger;

import com.fazecast.jSerialComm.SerialPort;
import java.util.ArrayList;

/**
 *
 * @author stefan
 */
public class SerialHandler 
{
    public static SerialHandler INSTANCE = null;
    public ArrayList<String> readBuffer = new ArrayList<>();
    public boolean isAvailable = false;
    public Thread __ReadThread = null;
    public SerialPort __p = null;
    public SerialHandler()
    {
        
    }
    public void __CallBack(String txt)
    {
        readBuffer.add(txt);
        isAvailable = true;
        System.out.println(txt);
    }
    
    public String ConsumeEvent()
    {
        if (!isAvailable)
        {
            return null;
        }
        
        if (readBuffer.size() == 1)
        {
            isAvailable = false;
        }
        
        String s = readBuffer.get(0);
        readBuffer.remove(0);
        return s;
    }
}
