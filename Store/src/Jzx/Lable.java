package Jzx;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.Sides;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Lable {
    private long jan;
    private String name;
    private int salesPrice;

    Lable(long jan ,String name, int salesPrice){
        this.jan=jan;
        this.name=name;
        this.salesPrice=salesPrice;

    }
    public static void main(String[] args){
        // Input the file
        fileCreate();
        FileInputStream textstream=null;
        try {
            textstream = new FileInputStream("file.txt");
        } catch (FileNotFoundException ffne) {
        }
        if (textstream == null) {
            return;
        }
// Set the document type
        DocFlavor myFormat = DocFlavor.INPUT_STREAM.TEXT_PLAIN_UTF_8;
// Create a Doc
        Doc myDoc = new SimpleDoc(textstream, myFormat, null);
// Build a set of attributes
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        aset.add(new Copies(5));
       // aset.add(MediaSize.ISOISO_A4);
        aset.add(Sides.DUPLEX);
// discover the printers that can print the format according to the
// instructions in the attribute set
        PrintService[] services =
                PrintServiceLookup.lookupPrintServices(myFormat, aset);
// Create a print job from one of the print services
        if (services.length > 0) {
            DocPrintJob job = services[0].createPrintJob();
            try {
                job.print(myDoc, aset);
            } catch (PrintException pe) {}
        }
    }


public static void fileCreate() {
    FileWriter fw = null;
    try {
        fw = new FileWriter(  "file.txt");
        fw.write("46000003321L");

    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

}
