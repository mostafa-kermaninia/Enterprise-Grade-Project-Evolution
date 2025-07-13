package main.symbolTable;

import java.util.*;
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.item.SymbolTableItem;

public class SymbolTable {

    public static SymbolTable top;
    public static SymbolTable root;
    private static Stack<SymbolTable> stack = new Stack<>();

    public static void push(SymbolTable symbolTable) {
        if (top != null)
            stack.push(top);
        top = symbolTable;
    }

    public static void pop() {
        top = stack.pop();
    }

    public SymbolTable pre;
    public Map<String, SymbolTableItem> items;

    public SymbolTable() {
        this(null);
    }

    public SymbolTable(SymbolTable pre) {
        this.pre = pre;
        this.items = new HashMap<>();
    }

    public static Stack<SymbolTable> getStack() {
        return stack;
    }

    public void put(SymbolTableItem item) throws ItemAlreadyExistsException {
        if (items.containsKey(item.getKey()))
            throw new ItemAlreadyExistsException();
        items.put(item.getKey(), item);
    }

    public SymbolTableItem getItem(String key) throws ItemNotFoundException {
        SymbolTable currentSymbolTable = this;
        while (currentSymbolTable != null) {
            SymbolTableItem symbolTableItem = currentSymbolTable.items.get(key);
            if (symbolTableItem != null) {
                symbolTableItem.setUsed();
                return symbolTableItem;
            }
            currentSymbolTable = currentSymbolTable.pre;
        }
        throw new ItemNotFoundException();
    }

    public int getItemsSize() {
        return this.items.size();
    }

    public SymbolTable getPre() {
        return pre;
    }

    public void setPre(SymbolTable pre) {
        this.pre = pre;
    }

    public Map<String, SymbolTableItem> getItems() {
        return this.items;
    }

    public void setItems(Map<String, SymbolTableItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "SymbolTable{itemsSize=" + items.size() + ", hasPre=" + (pre != null) + "}";
    }
}