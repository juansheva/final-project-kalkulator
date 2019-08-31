package com.example.kalkulator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvNol.setOnClickListener{appendOnExpression("0",true)}
        tvSatu.setOnClickListener{appendOnExpression("1",true)}
        tvDua.setOnClickListener{appendOnExpression("2",true)}
        tvTiga.setOnClickListener{appendOnExpression("3",true)}
        tvEmpat.setOnClickListener{appendOnExpression("4",true)}
        tvLima.setOnClickListener{appendOnExpression("5",true)}
        tvEnam.setOnClickListener{appendOnExpression("6",true)}
        tvTujuh.setOnClickListener{appendOnExpression("7",true)}
        tvDelapan.setOnClickListener{appendOnExpression("8",true)}
        tvSembilan.setOnClickListener{appendOnExpression("9",true)}
        tvTitik.setOnClickListener{appendOnExpression(".",true)}

        tvBagi.setOnClickListener{appendOnExpression("/",false)}
        tvKali.setOnClickListener{appendOnExpression("*",false)}
        tvTambah.setOnClickListener{appendOnExpression("+",false)}
        tvKurang.setOnClickListener{appendOnExpression("-",false)}
        tvBuka.setOnClickListener{appendOnExpression("(",false)}
        tvTutup.setOnClickListener{appendOnExpression(")",false)}

        tvBersihkan.setOnClickListener {
            tvExpression.text=""
            tvResult.text=""
        }

        tvHapus.setOnClickListener {
            val string=tvExpression.text.toString()
            if(string.isNotEmpty()){
                tvExpression.text=string.substring(0,string.length-1)
            }
            tvResult.text=""
        }
        tvHasil.setOnClickListener {
            try{
                val expression=ExpressionBuilder(tvExpression.text.toString()).build()
                val result=expression.evaluate()
                val longResult=result.toLong()
                if(result==longResult.toDouble())
                    tvResult.text=longResult.toString()
                else
                    tvResult.text=result.toString()

            }catch (e:Exception){
                Log.d("Exception","message:"+e.message)
            }
        }

    }
    fun appendOnExpression(string:String,canClear:Boolean){

        if(tvResult.text.isNotEmpty()){
            tvExpression.text=""
        }
        if(canClear){
            tvResult.text=""
            tvExpression.append(string)
        }else{
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text=""
        }
    }
}
