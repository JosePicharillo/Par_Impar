package br.edu.ifsp.scl.sdm.parouimpar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import br.edu.ifsp.scl.sdm.parouimpar.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * Referências para objetos de UI no layout
     */
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        exibirOpcoes();
        clickButtonSelect();
    }

    /**
     * Exibi ou oculta as opções
     */
    private void exibirOpcoes() {

        //Lambda
        activityMainBinding.mostraOpcoesSw.setOnCheckedChangeListener((__, mostrarOpcoes) ->{
            activityMainBinding.selecinarOpcaoLl.setVisibility(mostrarOpcoes? View.VISIBLE : View.GONE);
        });

//        activityMainBinding.mostraOpcoesSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean mostraOp) {
//                activityMainBinding.selecinarOpcaoLl.setVisibility(mostraOp ? View.VISIBLE : View.GONE);
//            }
//        });
    }

    /**
     * Ação de clique dos botões
     */
    private void clickButtonSelect() {
        activityMainBinding.zeroBT.setOnClickListener(this);
        activityMainBinding.umBT.setOnClickListener(this);
        activityMainBinding.doisBT.setOnClickListener(this);
        activityMainBinding.tresBT.setOnClickListener(this);
        activityMainBinding.quatroBT.setOnClickListener(this);
        activityMainBinding.cincoBT.setOnClickListener(this);
    }

    /**
     * Verifica qual botão foi selecionado
     */
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        int jogada = -1;
        switch (v.getId()) {
            case R.id.zeroBT:
                jogada = 0;
                break;
            case R.id.umBT:
                jogada = 1;
                break;
            case R.id.doisBT:
                jogada = 2;
                break;
            case R.id.tresBT:
                jogada = 3;
                break;
            case R.id.quatroBT:
                jogada = 4;
                break;
            case R.id.cincoBT:
                jogada = 5;
                break;
            default:
                break;
        }

        jogadaComputador(jogada);
    }

    /**
     * Veirifica a jogada do computador
     */
    private void jogadaComputador(int jogada) {
        Random random = new Random(System.currentTimeMillis());
        int jogadaComputador = random.nextInt(6);

        resultadoJogo(jogada, jogadaComputador);

    }

    /**
     * Calcula as jogadas e mostra os resultados
     */
    private void resultadoJogo(int jogada, int jogadaComputador) {

        StringBuilder resultadoSB = new StringBuilder();
        resultadoSB.append("Sua Jogada: ");
        resultadoSB.append(jogada);
        resultadoSB.append(", Jogada Computador: ");
        resultadoSB.append(jogadaComputador);
        resultadoSB.append('\n');

        if (activityMainBinding.opPar.isChecked()) {
            resultadoSB.append((jogada + jogadaComputador) % 2 == 0 ? "Você Ganhou!" : "Você Perdeu!");
        } else {
            resultadoSB.append((jogada + jogadaComputador) % 2 == 0 ? "Você Perdeu!" : "Você Ganhou!");
        }

        activityMainBinding.resultado.setText(resultadoSB.toString());

        imageSelectComputer(jogadaComputador);
    }

    /**
     * Setando imagem da jogada do computador
     */
    private void imageSelectComputer(int jogadaComputador) {
        int imgJogadaPC = -1;
        switch (jogadaComputador) {
            case 0:
                imgJogadaPC = R.mipmap.zero;
                break;
            case 1:
                imgJogadaPC = R.mipmap.one;
                break;
            case 2:
                imgJogadaPC = R.mipmap.two;
                break;
            case 3:
                imgJogadaPC = R.mipmap.three;
                break;
            case 4:
                imgJogadaPC = R.mipmap.four;
                break;
            case 5:
                imgJogadaPC = R.mipmap.five;
                break;
            default:
                break;
        }
        activityMainBinding.jgadaComputadorImg.setImageResource(imgJogadaPC);
    }

}