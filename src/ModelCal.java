import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ModelCal {

    private ScriptEngine scriptEngine;
    private String result;


    public ModelCal() {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        scriptEngine = scriptEngineManager.getEngineByName("JavaScript");
        this.result = "0";
    }

    private void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    void calcular(String expresion) {
        try {
            setResult(String.valueOf(scriptEngine.eval(expresion)));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    void borrarMemoria(){
        setResult("0");
    }

    void potencia2(String operador){
        double o = Double.parseDouble(operador);
        setResult(String.valueOf(Math.pow(o,2)));
    }

    void porcentaje(String operador){
        double x = Double.parseDouble(operador);
        setResult(String.valueOf(x/100));
    }

    void raizCuadrada(String operador) {
        double x = Double.parseDouble(operador);
        setResult(String.valueOf(Math.sqrt(x)));
    }


}
