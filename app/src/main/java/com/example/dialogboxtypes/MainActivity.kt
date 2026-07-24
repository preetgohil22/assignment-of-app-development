package com.example.dialogboxtypes

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dialogboxtypes.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btn2.setOnClickListener {
            //SINGLEDIALOG BOX
            val builder= AlertDialog.Builder(this)
            builder.setTitle("Choose the single option")
            val option=arrayOf("apple","orange","banana")
            builder.setSingleChoiceItems(option,0, DialogInterface.OnClickListener{ Dialog,which->
                val a = option[which]
                Toast.makeText(this, "Selected item is $a", Toast.LENGTH_SHORT).show()
            })
            builder.setPositiveButton("Yes", DialogInterface.OnClickListener{ Dialog,which->
                //
            })
            builder.setNegativeButton("Close") { Dialog,which->
                //close
            }
            builder.show()
        }

        binding.btn3.setOnClickListener{
            //MULTIPLAEDIALOG BOX
            val builder = AlertDialog.Builder(this)
            val options = arrayOf("vivo", "iphone", "samsung")
           builder.setMultiChoiceItems(options,null) { Dialog, which, ischecked ->
               val a=options[which]
               Toast.makeText(this, "Selected item is $a", Toast.LENGTH_SHORT).show()
           }
            builder.show()
        }

        binding.btn4.setOnClickListener {
            //ALERTDIALOG BOX
            val builder= AlertDialog.Builder(this)
            builder.setTitle("EXIT")
            builder.setMessage("ARE YOU SURE YOU WANT TO EXIT")
            builder.setPositiveButton("Yes") { Dialog,which-> finish() }
            builder.setNegativeButton("Close"){ Dialog,which-> }
            builder.show()
        }
        dialog= Dialog(this)
        dialog.setContentView(R.layout.customdialogbox)
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.bg))
        val close=dialog.findViewById<Button>(R.id.CLOSE)
        val ok=dialog.findViewById<Button>(R.id.ok)
        binding.custom.setOnClickListener {
            dialog.show()
            dialog.window?.setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT
            )
        }
        close.setOnClickListener {
            dialog.dismiss()
        }
        ok.setOnClickListener {
            dialog.dismiss()
        }
    }
}
    