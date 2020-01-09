package com.pvh98.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_calculator.*

class CalculatorFragment : Fragment(), View.OnClickListener {
    private var operationDecimal = false
    private var firstValue = 0.0f
    private var secondValue = 0.0f
    private var operationAdd = false
    private var operationSub = false
    private var operationMul = false
    private var operationDiv = false
    private var operationEuclidDiv = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_calculator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
    }

    private fun setListener() {
        buttonZero.setOnClickListener(this)
        buttonOne.setOnClickListener(this)
        buttonTwo.setOnClickListener(this)
        buttonThree.setOnClickListener(this)
        buttonFour.setOnClickListener(this)
        buttonFive.setOnClickListener(this)
        buttonSix.setOnClickListener(this)
        buttonSeven.setOnClickListener(this)
        buttonEight.setOnClickListener(this)
        buttonNine.setOnClickListener(this)
        buttonDot.setOnClickListener(this)
        buttonDelete.setOnClickListener(this)
        buttonDeleteAll.setOnClickListener(this)
        buttonAdd.setOnClickListener(this)
        buttonSub.setOnClickListener(this)
        buttonMutiple.setOnClickListener(this)
        buttonDivide.setOnClickListener(this)
        buttonEuclidDivision.setOnClickListener(this)
        buttonEqual.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.buttonOne,
            R.id.buttonTwo,
            R.id.buttonThree,
            R.id.buttonFour,
            R.id.buttonFive,
            R.id.buttonSix,
            R.id.buttonSeven,
            R.id.buttonEight,
            R.id.buttonNine,
            R.id.buttonZero -> {
                enterDigit((v as Button).text.toString())
            }

            R.id.buttonDot -> {
                enterDecimal()
            }

            R.id.buttonDeleteAll -> {
                enterClear()
            }

            R.id.buttonDelete -> {
                enterDelete()
            }

            R.id.buttonAdd -> {
                if (textResult.text.toString().length != 0) {
                    operationAdd = true
                    operationDecimal = false
                    enterValueOne()
                }
            }

            R.id.buttonSub -> {
                if (textResult.text.toString().length != 0) {
                    operationSub = true
                    operationDecimal = false
                    enterValueOne()
                }
            }

            R.id.buttonMutiple -> {
                if (textResult.text.toString().length != 0) {
                    operationMul = true
                    operationDecimal = false
                    enterValueOne()
                }
            }

            R.id.buttonDivide -> {
                if (textResult.text.toString().length != 0) {
                    operationDiv = true
                    operationDecimal = false
                    enterValueOne()
                }
            }

            R.id.buttonEuclidDivision -> {
                if (textResult.text.toString().length != 0) {
                    operationEuclidDiv = true
                    operationDecimal = false
                    enterValueOne()
                }
            }

            R.id.buttonEqual -> {

                if (operationAdd) {
                    secondValue = textResult.text.toString().toFloat()
                    textResult.text = (firstValue + secondValue).toString()
                    operationAdd = false
                }
                if (operationSub) {
                    secondValue = textResult.text.toString().toFloat()
                    textResult.text = (firstValue - secondValue).toString()
                    operationSub = false
                }
                if (operationMul) {
                    secondValue = textResult.text.toString().toFloat()
                    textResult.text = (firstValue * secondValue).toString()
                    operationMul = false
                }
                if (operationDiv) {
                    secondValue = textResult.text.toString().toFloat()
                    textResult.text = (firstValue / secondValue).toString()
                    operationDiv = false
                }
                if (operationEuclidDiv) {
                    textResult.text = (firstValue % secondValue).toString()
                    operationEuclidDiv = false
                }
            }
        }
    }

    private fun enterDecimal() {
        if (!operationDecimal) {
        } else {
            textResult.text = textResult.text.toString() + "."
            operationDecimal = true
        }

    }

    private fun enterDelete() {
        val num = textResult.text.toString().length
        val del = textResult.text.toString().substring(0, num - 1)
        textResult.text = del
    }

    private fun enterClear() {
        textResult.text = ""
        firstValue = 0F
        secondValue = 0F
    }


    private fun enterValueOne() {
        firstValue = textResult.text.toString().toFloat()
        textResult.text = null
    }

    private fun enterDigit(s: String) {
        textResult.text = textResult.text.toString() + s
    }

}
