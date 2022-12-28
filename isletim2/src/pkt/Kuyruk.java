package Proje;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Kuyruk {


    public static int satirsayisi(File f) throws FileNotFoundException {


        Scanner dosya = new Scanner(f);
        int satir = 0;

        while (dosya.hasNextLine()) {
            dosya.nextLine();
            satir++;
        }
        dosya.close();

        return satir;
    }

    public int donguSayisi() throws FileNotFoundException {
        File f = new File("C:\\Users\\Ozzen\\OneDrive\\Masaüstü\\asdasdsa\\IsletimSistemiProje\\src\\Proje\\giriş.txt");

        int sayac= satirsayisi(f);
        int donmeSayaci =0;
        int[][] dizi = new int[sayac][3];
        Scanner dosya = new Scanner(f);
        int satir = 0;

        while (dosya.hasNextLine()) {
            String satirstring = dosya.nextLine();

            String[] arrSplit = satirstring.split(", ");
            int dizisatir = 0;
            for (String arrSplit1 : arrSplit) {

                dizi[satir][dizisatir] = Integer.parseInt(arrSplit1);

                dizisatir++;

            }

            donmeSayaci += dizi[satir][2];

        }
        dosya.close();

        return donmeSayaci;
    }
    public ArrayList<Process> nesneolustur() throws FileNotFoundException {
        /*


        STABLE ARRAYLİST YAP


         */

        File f = new File("C:\\Users\\Ozzen\\OneDrive\\Masaüstü\\asdasdsa\\IsletimSistemiProje\\src\\Proje\\giriş.txt");

        int donmeSayaci=0;

        Scanner dosyaIslem = new Scanner(f);
        int satir = satirsayisi(f);


        int sayac = 0;
        int[][] dizi = new int[satir][6];


        Process[] stable = new Process[satir];


        while (dosyaIslem.hasNextLine()) {
            String satirstring = dosyaIslem.nextLine();

            String[] arrSplit = satirstring.split(", ");
            int dizisatir = 1;
            for (String arrSplit1 : arrSplit) {

                dizi[sayac][dizisatir] = Integer.parseInt(arrSplit1);

                dizisatir++;

            }
            dizi[sayac][0] = sayac;

            dizi[sayac][4] = 0;
            dizi[sayac][5] = -1;
            Process kukla = new Process(dizi[sayac]);
            stable[sayac] = kukla;
            //ver.add(kukla);
            //System.out.println(stable[sayac]);
            donmeSayaci += dizi[sayac][3];
            sayac++;
        }
        /*
        System.out.println();

        for(int i = 0; i<satir; i++) {
          for(int j = 0; j<4;j++) {

               System.out.println(dizi[i][j]);
           }
           System.out.println("\n");
        }*/
        ArrayList<Process> ver = new ArrayList<Process>(Arrays.asList(stable));
        return ver;
    }

    public ArrayList<Process> varisZamaniBelirle(ArrayList<Process> kuyruk, int saniye) {


        ArrayList<Process> araci = new ArrayList<Process>();
        /*
        int sayac=0;
        for (Process eleman:kuyruk) {
            if (eleman.varisZamani == saniye) {
                sayac++;
            }
        }
        Process[] araci= new Process[sayac];
        */

        for (Process eleman : kuyruk) {
            if (eleman.varisZamani == saniye) {
                araci.add(eleman);
            }
        }

        return araci;
    }


    public ArrayList<ArrayList> kuyrukCheck(ArrayList<Process> kuyrukSaniye, ArrayList<Process> realTimeLastList, ArrayList<Process> userJobLastList) {

        for (Process eleman : kuyrukSaniye) {

            switch (eleman.oncelik) {
                case 0:
                    realTimeLastList.add(eleman);
                    break;
                default:
                    userJobLastList.add(eleman);
                    break;
            }
        }
        ArrayList<ArrayList> listeFull = new ArrayList<ArrayList>();
        listeFull.add(realTimeLastList);
        listeFull.add(userJobLastList);
        listeFull.set(0, realTimeLastList);
        listeFull.set(1, userJobLastList);
        return listeFull;
    }

    public void ekran(int saniye, int Statament, Process activeProcess) {

        // 0 başladı / 1 yürütülüyor / 2 askıda / 3 sonlandı / 4 zamanaşımı
        switch (Statament) {
            case 0:
                System.out.println(saniye + " sn process başladı\t\t(id:" + activeProcess.Id + "\töncelik:" + activeProcess.oncelik + "\tkalan süre:" + activeProcess.calismaZamani + " sn aşımZamanı:" + activeProcess.asimZamani +"  Flag:"+ activeProcess.flag+" )");
                break;
            case 1:
                System.out.println(saniye + " sn process yürütülüyor\t\t(id:" + activeProcess.Id + "\töncelik:" + activeProcess.oncelik + "\tkalan süre:" + activeProcess.calismaZamani + " sn aşımZamanı:" + activeProcess.asimZamani +"  Flag:"+ activeProcess.flag+" )");
                break;
            case 2:
                System.out.println(saniye + " sn process askıda\t\t\t(id:" + activeProcess.Id + "\töncelik:" + activeProcess.oncelik + "\tkalan süre:" + activeProcess.calismaZamani + " sn aşımZamanı:" + activeProcess.asimZamani +"  Flag:"+ activeProcess.flag+" )");
                break;
            case 3:
                System.out.println(saniye + " sn process sonlandı\t\t(id:" + activeProcess.Id + "\töncelik:" + activeProcess.oncelik + "\tkalan süre:" + activeProcess.calismaZamani + " sn aşımZamanı:" + activeProcess.asimZamani +"  Flag:"+ activeProcess.flag+" )");
                break;
            case 4:
                System.out.println(saniye + " sn process zamanaşımı\t\t(id:" + activeProcess.Id + "\töncelik:" + activeProcess.oncelik + "\tkalan süre:" + activeProcess.calismaZamani + " sn aşımZamanı:" + activeProcess.asimZamani +"  Flag:"+ activeProcess.flag+" )");
                break;
        }
    }

    public ArrayList<ArrayList> realTime(ArrayList<Process> realTimeLastList, Process activeProcess, int saniye) {


        if (activeProcess.Id == -1) {
            activeProcess = realTimeLastList.get(0);
            //activeProcess.Id = realTimeLastList.get(0).Id;
            ekran(saniye, 0, activeProcess);
            activeProcess.calismaZamani -= 1;

        } else if ((activeProcess.oncelik == 0) && (activeProcess.calismaZamani != 0)) {
            ekran(saniye, 1, activeProcess);
            activeProcess.calismaZamani -= 1;
        } else if ((activeProcess.oncelik == 0) && (activeProcess.calismaZamani == 0)) {
            ekran(saniye, 3, activeProcess);
            realTimeLastList.remove(0);
            if (!realTimeLastList.isEmpty()) {
                activeProcess = realTimeLastList.get(0);
                ekran(saniye, 0, activeProcess);
                activeProcess.calismaZamani -= 1;
            }
        } else {//onceligi 0 dan farklı olanlar girecek
            //flag true olacak
            //saniye degeri asimzamanina atilir.
            //aktifprocess realtime ile degiscek

            activeProcess.asimZamani = saniye;
            ekran(saniye, 2, activeProcess);

            /*if (activeProcess.oncelik != 3 && activeProcess.oncelik++ !=3) {
                activeProcess.oncelik++;
            }*/
            activeProcess = realTimeLastList.get(0);
            ekran(saniye, 0, activeProcess);
            activeProcess.calismaZamani--;

        }

        pio1Evrensel = zamanAsimiKontrol(pio1Evrensel,saniye);
        pio2Evrensel = zamanAsimiKontrol(pio2Evrensel,saniye);
        pio3Evrensel = zamanAsimiKontrol(pio3Evrensel,saniye);

        ArrayList<ArrayList> realTimeReturn = new ArrayList<ArrayList>();
        ArrayList<Process> processArray = new ArrayList<Process>();
        processArray.add(activeProcess);
        realTimeReturn.add(processArray);
        realTimeReturn.add(realTimeLastList);
        realTimeReturn.set(0, realTimeLastList);
        realTimeReturn.set(1, processArray);

        return realTimeReturn;

    }

    public ArrayList<ArrayList> UserjobQueue(ArrayList<Process> userJobList, Process activeProcess, int saniye) {

        //System.out.println(userJobList);
        //System.out.println("UserjobQueue veri...");

        for (Process processler : userJobList) {
            if (processler.oncelik == 1) {
                pio1Evrensel.add(processler);
            } else if (processler.oncelik == 2) {
                pio2Evrensel.add(processler);
            } else if (processler.oncelik == 3) {
                pio3Evrensel.add(processler);
            }
        }


        if (!pio1Evrensel.isEmpty()) {
            if(activeProcess.oncelik!=0 &&activeProcess.oncelik!=-1  && activeProcess.calismaZamani!=0){ekran(saniye, 2, activeProcess);}
            activeProcess.asimZamani=saniye;
            activeProcess = pio1Evrensel.get(0);
            pio1Evrensel.remove(0);
            if ((activeProcess.calismaZamani - 1) > 0) {
                ekran(saniye, 0, activeProcess);
                activeProcess.calismaZamani--;
                activeProcess.oncelik++;
                //activeProcess.asimZamani=saniye;
                pio2Evrensel.add(activeProcess);
                //ekran(saniye, 2, activeProcess);
            } else if(activeProcess.calismaZamani==1){

                ekran(saniye, 0,activeProcess);

                activeProcess.calismaZamani--;
                activeProcess.oncelik++;
                ekran(saniye, 3,activeProcess);

            }else {
                activeProcess.calismaZamani--;
                activeProcess.oncelik++;
                ekran(saniye, 3, activeProcess);

            }

        } else if (!pio2Evrensel.isEmpty()) {
            if(activeProcess.oncelik!=0 &&activeProcess.oncelik!=-1 && activeProcess.calismaZamani!=0){ekran(saniye, 2, activeProcess);}
            activeProcess.asimZamani=saniye;
            activeProcess = pio2Evrensel.get(0);
            pio2Evrensel.remove(0);
            if ((activeProcess.calismaZamani - 1) > 0) {
                ekran(saniye, 0, activeProcess);
                activeProcess.calismaZamani--;
                activeProcess.oncelik++;
                //activeProcess.asimZamani=saniye;
                pio3Evrensel.add(activeProcess);
                //ekran(saniye, 2, activeProcess);
            }else if(activeProcess.calismaZamani==1){

                ekran(saniye, 0,activeProcess);

                activeProcess.calismaZamani--;
                activeProcess.oncelik++;
                ekran(saniye, 3,activeProcess);

            }
            else {
                activeProcess.calismaZamani--;
                activeProcess.oncelik++;
                ekran(saniye, 3, activeProcess);
            }
        } else if (!pio3Evrensel.isEmpty()) {
            if(activeProcess.oncelik!=0 &&activeProcess.oncelik!=-1  && activeProcess.calismaZamani!=0){ekran(saniye, 2, activeProcess);}
            activeProcess.asimZamani=saniye;
            activeProcess = pio3Evrensel.get(0);
            pio3Evrensel.remove(0);
            if ((activeProcess.calismaZamani - 1) > 0) {
                ekran(saniye, 0, activeProcess);
                activeProcess.calismaZamani--;
                //activeProcess.asimZamani=saniye;
                pio3Evrensel.add(activeProcess);
                //ekran(saniye, 2, activeProcess);
            }else if(activeProcess.calismaZamani==1){
                ekran(saniye, 0,activeProcess);
                activeProcess.calismaZamani--;
                ekran(saniye+1, 3,activeProcess);

            }
            else {
                activeProcess.calismaZamani--;
                ekran(saniye, 3, activeProcess);
            }
        }


        for ( var item:userJobList ) {
            if(item.Id==activeProcess.Id){
                item = activeProcess;
            }
        }


        //ArrayList<ArrayList> zamanAsimi = new ArrayList<ArrayList>();

        pio1Evrensel = zamanAsimiKontrol(pio1Evrensel,saniye);
        pio2Evrensel = zamanAsimiKontrol(pio2Evrensel,saniye);
        pio3Evrensel = zamanAsimiKontrol(pio3Evrensel,saniye);


        ArrayList<ArrayList> userJobReturn = new ArrayList<ArrayList>();
        ArrayList<Process> processArray = new ArrayList<Process>();
        processArray.add(activeProcess);
        userJobReturn.add(processArray);
        userJobReturn.add(userJobList);
        userJobReturn.set(0, userJobList);
        userJobReturn.set(1, processArray);


        return userJobReturn;

    }

    ArrayList<Process> pio1Evrensel;
    ArrayList<Process> pio2Evrensel;
    ArrayList<Process> pio3Evrensel;

    public Kuyruk() {
        pio1Evrensel = new ArrayList<Process>();
        pio2Evrensel = new ArrayList<Process>();
        pio3Evrensel = new ArrayList<Process>();
    }

    public ArrayList<Process> zamanAsimiKontrol(ArrayList<Process> list,int saniye) {
        int i = list.size();
            if(i==0) return list;

        for(int a=0;a<i;a++) {
            if (saniye - list.get(a).asimZamani == 20 && list.get(a).asimZamani != -1) {
                ekran(saniye, 4, list.get(a));
                list.remove(a);
                i--;
                if (list.size() == 0) {
                    break;
                }

            }

            /*for (Process item : list) {
                if (saniye - item.asimZamani == 20 && item.asimZamani != -1) {
                    ekran(saniye, 4, item);
                    list.remove(item);
                    if (list.size() == 0) {
                        break;
                    }
                }

        }*/
        }
        return list;
    }
}


// BUNLARI KALDIR BURADAN SONRA
    /*public Process pio1F(ArrayList<Process> pio1List, Process activeProcess){

        if(pio1Evrensel.isEmpty()){
            for (Process eleman:pio1List) {
                pio1Evrensel.add(eleman);
            }
        }else if (!pio1Evrensel.isEmpty()){
            activeProcess = pio1Evrensel.get(0);
        }
        return activeProcess;
    }
    public ArrayList<Process> pio2F(ArrayList<Process> pio2List){

    }
    public ArrayList<Process> pio3F(ArrayList<Process> pio3List){

    }
}
*/