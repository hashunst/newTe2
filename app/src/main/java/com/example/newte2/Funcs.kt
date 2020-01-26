package com.example.newte2

import android.content.Context
import android.widget.Toast


fun toast(context: Context, str: String) {
    Toast.makeText(context, str, Toast.LENGTH_LONG).show()
}