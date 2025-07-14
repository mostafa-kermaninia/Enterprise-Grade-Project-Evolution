
package main.types;

public abstract class Type {
    public boolean sameType(Type other) {
        return (this.getClass().equals(other.getClass())) && !((this instanceof T_Non) || (other instanceof T_Non));
    }

}
