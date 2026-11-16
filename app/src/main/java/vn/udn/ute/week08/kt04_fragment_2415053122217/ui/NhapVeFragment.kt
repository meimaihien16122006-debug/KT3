package vn.udn.ute.kt04_fragment_2415053122217.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import vn.udn.ute.kt04_fragment_2415053122217.R
import vn.udn.ute.kt04_fragment_2415053122217.model.PhieuVe
import vn.udn.ute.kt04_fragment_2415053122217.utils.QuyTacPhieu
import vn.udn.ute.kt04_fragment_2415053122217.utils.chuanHoaten

class NhapVeFragment : Fragment() {

    private lateinit var edtHoTen: EditText
    private lateinit var edtSoLuong: EditText
    private lateinit var btnXemVe: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_nhap_ve, container, false)
        edtHoTen = view.findViewById(R.id.edtHoTen)
        edtSoLuong = view.findViewById(R.id.edtSoLuong)
        btnXemVe = view.findViewById(R.id.btnXemVe)

        btnXemVe.setOnClickListener {
            xemVe()
        }

        return view
    }

    private fun xemVe() {
        val rawName = edtHoTen.text.toString()
        val rawSoLuong = edtSoLuong.text.toString()
        val chuanName = rawName.chuanHoaten()
        if (chuanName.length !in 2..40) {
            edtHoTen.error = "Họ tên phải từ 2 đến 40 ký tự!"
            return
        }
        val soLuong = rawSoLuong.toIntOrNull()
        if (soLuong == null || soLuong !in 1..9) {
            edtSoLuong.error = "Số lượng phải là số nguyên từ 1 đến 9!"
            return
        }
        val maVe = QuyTacPhieu.taoMaPhieu(QuyTacPhieu.getNextIndex())
        val phieuVe = PhieuVe(maVe, chuanName, soLuong)
        val bundle = Bundle().apply {
            putString("maVe", phieuVe.maVe)
            putString("hoTen", phieuVe.hoTen)
            putInt("soLuong", phieuVe.soLuong)
        }
        setFragmentResult("ve_tao", bundle)
        val xacNhanFragment = XacNhanVeFragment().apply {
            arguments = bundle
        }
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentHost, xacNhanFragment)
            .addToBackStack(null)
            .commit()
    }

    }