import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerCal {

    private static ViewCal view;
    private static ModelCal model;

    ControllerCal(ViewCal viewCal, ModelCal modelCal) {

        view = viewCal;
        model = modelCal;
        viewCal.setVisible(true);

    }

    static class igualListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            String operando;
            String operador;

            try {

                operando = view.getDataSaved().getText();
                operador = view.getData().getText();

                if (!operador.equalsIgnoreCase("0")) {
                    model.calcular(operando, operador);

                    view.getDataSaved().setText(String.valueOf(model.getResult()));
                    view.getData().setText("0");
                } else {
                    view.getDataSaved().setText(String.valueOf(model.getResult()));
                }

            } catch(NumberFormatException ex) {
                ex.printStackTrace();
            }

        }

    }

    static class ACListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            view.getDataSaved().setText("0");
            view.getData().setText("0");
            model.borrarMemoria();
        }

    }

    static class PowListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String operador = view.getData().getText();

            if (!operador.equalsIgnoreCase("0")) {
                model.potencia2(operador);
                view.getDataSaved().setText(String.valueOf(model.getResult()));
                view.getData().setText("0");
            }
        }
    }

    static class PercentListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String operador = view.getData().getText();

            if (!operador.equalsIgnoreCase("0")) {
                model.porcentaje(operador);
                view.getDataSaved().setText(String.valueOf(model.getResult()));
                view.getData().setText("0");
            }
        }
    }


    static class SqrtListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String operador = view.getData().getText();

            if (!operador.equalsIgnoreCase("0")) {
                model.raizCuadrada(operador);
                view.getDataSaved().setText(String.valueOf(model.getResult()));
                view.getData().setText("0");
            }
        }
    }

    static class OperatorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String operador = view.getData().getText();

            double x = Double.parseDouble(operador);
            double y = Double.parseDouble(model.getResult());

            if (!operador.substring(operador.length()-1).contains(e.getActionCommand())) {
                    model.calcular(model.getResult(), operador);
                    view.getDataSaved().setText(operador + e.getActionCommand());
                    view.getData().setText("0");
            }


        }
    }


}
