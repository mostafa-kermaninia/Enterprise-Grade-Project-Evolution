package main.ast.nodes.expr.primitives;

import main.ast.nodes.expr.Expr;
import main.types.CharType;
import main.types.IntType;
import main.types.Type;
import main.visitor.IVisitor;

public class CharVal extends Value {
    private char char_val;

    public CharVal(String string_val){this.char_val =  string_val.charAt(1); ;}

    public char get_char_val() {
        return char_val;
    }

    public void set_string_val(char string_val) {
        this.char_val = string_val;
    }
    @Override
    public String toString(){return "CharValue:" +this.char_val;}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}

    public Type get_type() {
        return new CharType();
    }
}

