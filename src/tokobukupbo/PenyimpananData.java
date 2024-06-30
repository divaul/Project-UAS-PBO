/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tokobukupbo;

/**
 *
 * @author DIVAUL
 */
public class PenyimpananData {
    private Item[] items;
    private int count;

    public PenyimpananData(int size) {
        items = new Item[size];
        count = 0;
    }

    public void addItem(Item item) {
        if (count < items.length) {
            items[count] = item;
            count++;
        } else {
            System.out.println("Peyimpanan Penuh.");
        }
    }

    public Item searchItem(String title) {
        for (int i = 0; i < count; i++) {
            if (items[i].getJudul().equalsIgnoreCase(title)) {
                return items[i];
            }
        }
        return null;
    }

    public Item[] getAllItems() {
        Item[] result = new Item[count];
        System.arraycopy(items, 0, result, 0, count);
        return result;
    }

    public int getCount() {
        return count;
    }
}


