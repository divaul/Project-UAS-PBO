/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tokobukupbo;

/**
 *
 * @author DIVAUL
 */
public class Item {
    private String judul;
    private String penerbit;
    private int tahunCetak;
    private String kategori;

    public Item(String judul, String penerbit, int tahunCetak, String kategori) {
        this.judul = judul;
        this.penerbit = penerbit;
        this.tahunCetak = tahunCetak;
        this.kategori = kategori;
    }

    public String getJudul() { return judul; }
    public String getPenerbit() { return penerbit; }
    public int getTahunCetak() { return tahunCetak; }
    public String getKategori() { return kategori; }

    @Override
    public String toString() {
        return "Judul: " + judul + "\n" +
               "Penerbit: " + penerbit + "\n" +
               "Tahun Cetak: " + tahunCetak + "\n" +
               "Kategori: " + kategori;
    }
}
