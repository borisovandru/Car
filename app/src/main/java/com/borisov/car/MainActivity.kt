package com.borisov.car

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.borisov.car.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var bind: ActivityMainBinding
    private val presenter: Presenter by lazy {
        Presenter(bind)
    }

    private val listener: View.OnClickListener = View.OnClickListener {
        when (it.id) {
            bind.up.id -> presenter.pressedUp()
            bind.down.id -> presenter.pressedDown()
            bind.left.id -> presenter.pressedLeft()
            bind.right.id -> presenter.pressedRight()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        setListeners()
    }

    private fun setListeners() {
        bind.up.setOnClickListener(listener)
        bind.down.setOnClickListener(listener)
        bind.left.setOnClickListener(listener)
        bind.right.setOnClickListener(listener)
    }
}
