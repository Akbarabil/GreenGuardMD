package com.dicoding.greenguard.fragment.forum

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.greenguard.adapter.ForumAdapter
import com.example.greenguard.databinding.FragmentForumBinding

class ForumFragment : Fragment() {

    private lateinit var binding: FragmentForumBinding
    private lateinit var forumAdapter: ForumAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentForumBinding.inflate(inflater, container, false)

        // Initialize data for adapter
        val dataList = getDataList()

        // Initialize adapter
        forumAdapter = ForumAdapter(dataList)

        // Set layout manager and adapter to RecyclerView
        binding.rvForum.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = forumAdapter
        }

        return binding.root
    }

    private fun getDataList(): List<ForumAdapter.ItemData> {
        return listOf(
            ForumAdapter.ItemData(
                "Ababil Sitohang",
                "Penyakit Busuk Buah: Penyakit busuk buah disebabkan oleh jamur yang membuat buah menjadi lunak dan berair."
            ),
            ForumAdapter.ItemData(
                "Budi Cahyono",
                "Antraknosa: Antraknosa menyebabkan bercak hitam pada daun dan buah yang lama kelamaan akan membusuk."
            ),
            ForumAdapter.ItemData(
                "Citra Dewi",
                "Embun Tepung: Penyakit ini ditandai dengan lapisan putih seperti tepung pada permukaan daun dan buah."
            ),
            ForumAdapter.ItemData(
                "Dewa Nugraha",
                "Karat Buah: Karat pada buah disebabkan oleh jamur yang menyebabkan warna kecoklatan pada permukaan buah."
            ),
            ForumAdapter.ItemData(
                "Eka Surya",
                "Penyakit Bercak Coklat: Penyakit ini menyebabkan bercak coklat pada kulit buah yang dapat merusak buah secara keseluruhan."
            ),
            ForumAdapter.ItemData(
                "Farhan Azhar",
                "Busuk Hitam: Penyakit ini membuat buah membusuk dan berubah menjadi warna hitam."
            ),
            ForumAdapter.ItemData(
                "Gita Putri",
                "Kanker Bakteri: Kanker bakteri dapat menyebabkan luka terbuka pada kulit buah."
            ),
            ForumAdapter.ItemData(
                "Hadi Wijaya",
                "Penyakit Busuk Hati: Busuk hati pada buah disebabkan oleh infeksi jamur dan dapat membuat buah menjadi lembek."
            ),
            ForumAdapter.ItemData(
                "Indah Permata",
                "Keropeng Daun: Keropeng daun ditandai dengan adanya lapisan kering dan kasar pada permukaan daun."
            ),
            ForumAdapter.ItemData(
                "Joko Santoso",
                "Penyakit Lecah: Lecah pada buah disebabkan oleh jamur yang membuat buah menjadi lunak dan berair."
            ),
            ForumAdapter.ItemData(
                "Kartika Puspita",
                "Penyakit Layu Fusarium: Penyakit ini menyebabkan tanaman mengalami layu dan kemudian mati."
            ),
            ForumAdapter.ItemData(
                "Lukman Hakim",
                "Busuk Batang: Penyakit ini mengakibatkan busuk pada batang tanaman buah."
            ),
            ForumAdapter.ItemData(
                "Mega Wati",
                "Karat Daun: Karat daun terjadi karena infeksi jamur yang menyebabkan munculnya bercak kuning dan merah di daun."
            ),
            ForumAdapter.ItemData(
                "Nanda Perdana",
                "Penyakit Bercak Abu-Abu: Bercak abu-abu pada buah disebabkan oleh jamur yang menyerang buah yang matang."
            ),
            ForumAdapter.ItemData(
                "Oscar Damanik",
                "Penyakit Belah Buah: Penyakit ini menyebabkan buah retak atau belah akibat kondisi lingkungan yang tidak ideal."
            ),
            ForumAdapter.ItemData(
                "Putri Mardiana",
                "Penyakit Kuning Daun: Daun tanaman buah menguning akibat kekurangan nutrisi tertentu atau infeksi."
            ),
            ForumAdapter.ItemData(
                "Rahmat Hidayat",
                "Penyakit Busuk Kering: Busuk kering pada buah disebabkan oleh jamur dan membuat buah mengering."
            ),
            ForumAdapter.ItemData(
                "Sari Mulia",
                "Penyakit Rebah Kecambah: Kecambah tanaman buah rebah karena infeksi jamur atau bakteri."
            ),
            ForumAdapter.ItemData(
                "Tono Saputra",
                "Penyakit Luka Bakar: Luka bakar pada buah disebabkan oleh terik matahari yang berlebihan atau bahan kimia."
            )
        )
    }

}
