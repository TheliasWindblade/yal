package arbre.expressions.unaires;

import arbre.expressions.Expression;
import exceptions.NonConcordanceTypeException;
import tds.types.Type;
import tds.types.TypesVariable;

public class Negatif extends Expression {

    protected Expression exp;

    public Negatif(Expression g, int n){
        super(n);
        this.exp = g;
    }

    @Override
    public void verifier() {
        exp.verifier();
        if(!exp.getType().concorde(new Type(TypesVariable.ENTIER))){
            throw new NonConcordanceTypeException(noLigne, "Négatif nécessite un entier");
        }
    }

    @Override
    public Type getType() {
        return new Type(TypesVariable.ENTIER);
    }

    @Override
    public String toMIPS() {
        return  "          # Début de l'opposée\n" +
                exp.toMIPS() +
                "     # Execution de l'opposée\n" +
                "     negu $v0, $v0\n\n";
    }
}
