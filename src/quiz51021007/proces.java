/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz51021007;
import java.io.*;
/**
 *
 * @author HP VICTUS
 */
public class proces {
    private int nim, total, totallulus, totaltidaklulus;
    private String nama,nilaihuruf,keterangan;
    private double tugas,quiz,uas,uts,nilaiakhir;
    
    proces(){
        nim=51021007;
        nama="Wilbert";
        tugas=0.0;
        quiz=0.0;
        uas=0.0;
        uts=0.0;
        nilaiakhir=0.0;
        nilaihuruf="E";
    }
    
    public int getNim(){
        return nim;
    }
    public String getNama(){
        return nama;
    }
    public double getTugas(){
        return tugas;
    }
    public double getQuiz(){
        return quiz;
    }
    public double getUas(){
        return uas;
    }
    public double getUts(){
        return uts;
    }
    public double getNilaiakhir(){
        return nilaiakhir;
    }
    public String getNilaihuruf(){
        return nilaihuruf;
    }
    
    public double setNilaiakhir(double tugas,double quiz,double uts,double uas){
        nilaiakhir=(0.2* tugas) + (0.2* quiz) +(0.3*uts) + (0.3*uas);
        return nilaiakhir;
    }
    public void setNilaihuruf(double x){
        if(x>=80){
            nilaihuruf="A";
            keterangan="Lulus";
        }else if(x>=70&&x<80){
            nilaihuruf="B";
            keterangan="Lulus";
        }else if(x>=60&&x<70){
            nilaihuruf="C";
            keterangan="Lulus";
        }else if(x>=50&&x<60){
            nilaihuruf="D";
            keterangan="Lulus";
        }else{
            nilaihuruf="E";
            keterangan="Tidak Lulus";
        }
    }
    
     public void simpanData(String nim,String nama, String tugas, String quiz, String uts, String uas, String nilaiakhir, String nilaihuruf){
        try{
            File file=new File("Quiz51021007.dat");
            BufferedWriter output=new BufferedWriter(new FileWriter(file,true));
            output.write(nim+";");
            output.write(nama+";");
            output.write(tugas+";");
            output.write(quiz+";");
            output.write(uts+";");
            output.write(uas+";");
            output.write(nilaiakhir+";");
            output.write(nilaihuruf+";");
            output.write("\n");
            output.close();
        }catch(IOException e){
            System.out.println(e.toString());
        }
}
    public String bacaData(){
        String line;
        String temp="";
        String[] aray={"NIM = ","Nama = ","Nilai Tugas = ","Nilai Quiz = ","Nilai UTS = ","Nilai UAS = ","Nilai Angka = ","Nilai Huruf= "};
        try{
            File file=new File("Quiz51021007.dat");
            BufferedReader input=new BufferedReader(new FileReader(file));
            while((line=input.readLine())!=null){
                String[] str = line.split(";", 9);
                for (int i = 0; i < aray.length; i++)
                    temp+=aray[i]+str[i]+"\n";
                    temp=temp+"\n";
                if(str[7].equals("E")){
                    totaltidaklulus++;
                }
                if(!str[7].equals("E")){
                    totallulus++;
                }
                if (!temp.isEmpty()) {
                    total++;
                }
            }   
            input.close();
        }catch(IOException e){
            System.out.println(e.toString());
        }
        return(temp+"\n");
    }
    
    
    public int getTotal() {
        return total;
    }
    public int getTotallulus() {
        return totallulus;
    }
    public int getTotaltidaklulus() {
        return totaltidaklulus;
    }
}
