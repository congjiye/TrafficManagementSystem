package com.atcong.Util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 生成验证码工具类
 */
public class GraphicsUtil {

    private Font font = new Font("Times New Roman",Font.ITALIC,17);

    Color getColor(int fc,int bc){
        Random random = new Random();
        if(fc > 255){
            fc = 255;
        }
        if(bc > 255){
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r,g,b);
    }

    public Map<String,Object> getGraphics(){
        int width = 80;
        int height = 25;
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
        Graphics g = image.getGraphics();
        Random random = new Random();
        g.setColor(getColor(200,250));
        g.fillRect(1,1,width - 1,height - 1);
        g.setColor(new Color(102,102,102));
        g.setFont(font);
        g.setColor(getColor(160,200));
        for(int i = 5 ; i < 70 ; i++){
            int x = random.nextInt(width - 1);
            int y = random.nextInt(height - 1);
            int xl = random.nextInt(6) + 1;
            int yl = random.nextInt(12) + 1;
            g.drawLine(x,y,x + xl,y + yl);
        }
        for(int i = 0 ; i < 40 ; i++){
            int x = random.nextInt(width - 1);
            int y = random.nextInt(height - 1);
            int xl = random.nextInt(6) + 1;
            int yl = random.nextInt(12) + 1;
            g.drawLine(x,y,x - xl,y - yl);
        }
        String sRand = "";
        for(int i = 0 ; i < 4; i ++){
            int itmp = random.nextInt(26) + 65;
            char ctmp = (char)itmp;
            sRand += String.valueOf(ctmp);
            g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
            g.drawString(String.valueOf(ctmp),15*i+10,16);
        }

        g.dispose();

        Map<String, Object> map=new HashMap<String, Object>();
        map.put("rand", sRand);
        map.put("image", image);
        return map;
    }

    public static void main(String[] args) throws IOException {
        OutputStream out = new FileOutputStream("C:\\Users\\Aydon\\IdeaProjects\\graduation\\src\\main\\webapp\\image\\Verification"+".jpg");
        GraphicsUtil graphicsUtil = new GraphicsUtil();
        Map<String,Object>map = graphicsUtil.getGraphics();
        ImageIO.write((RenderedImage)map.get("image"),"jpeg",out);
        System.out.println("验证码的值为："+ map.get("rand"));
    }
}
