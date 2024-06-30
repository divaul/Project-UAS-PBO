/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tokobukupbo;

/**
 *
 * @author DIVAUL
 */
public class Buku extends Item {

    /**
     * @param args the command line arguments
     */

    private String namaPengarang;

    public Buku(String judul, String namaPengarang, String penerbit, int tahunCetak, String kategori) {
        super(judul, penerbit, tahunCetak, kategori);
        this.namaPengarang = namaPengarang;
    }

    public String getNamaPengarang() { return namaPengarang; }

    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Nama Pengarang: " + namaPengarang;
    }
}


    

