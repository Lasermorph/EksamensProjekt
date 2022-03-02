/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.openjfx.javamessenger;
import com.fazecast.jSerialComm.*;
import java.io.InputStream;

/**
 *
 * @author stefan
 */
public class BackgroundReader implements Runnable
{
    SerialPort p = null;
    InputStream in = null;
    boolean newData = false;
    byte[] data = null;
    public BackgroundReader(SerialPort _p)
    {
        p = _p;
        //in = p.getInputStream();
        p.addDataListener(new SerialPortDataListener() {
            @Override
            public int getListeningEvents() {
                return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
            }

            @Override
            public void serialEvent(SerialPortEvent event) {
                if (event.getEventType() != SerialPort.LISTENING_EVENT_DATA_AVAILABLE)
                {
                    return;
                }
                byte[] readData = new byte[p.bytesAvailable()];
                int bytesRead = p.readBytes(readData, readData.length);
                data = readData;
                newData = true;
            }
        });
    }
    @Override
    public void run()
    {
        System.out.println("Hello there");
        while(true)
        {
            if(!p.isOpen())
            {
                System.out.println("bye bye");
                return;
            }
            if(newData)
            {
                newData = false;
                SerialHandler.INSTANCE.__CallBack(new String(data));
            }
        }
    }
}
