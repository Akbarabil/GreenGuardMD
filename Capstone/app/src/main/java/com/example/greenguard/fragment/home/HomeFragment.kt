package com.dicoding.greenguard.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.greenguard.R
import com.example.greenguard.adapter.NewsAdapter
import com.example.greenguard.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var newsAdapter: NewsAdapter
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        // Inisialisasi ViewModel
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        // Inisialisasi RecyclerView dan Adapter
        setupRecyclerView()

        // Observasi LiveData jika diperlukan
        observeViewModel()

        return binding.root
    }

    private fun setupRecyclerView() {
        // Inisialisasi data untuk adapter
        val dataList = getDataList()

        // Inisialisasi adapter
        newsAdapter = NewsAdapter(dataList)

        // Set layout manager dan adapter ke RecyclerView
        binding.rvNews.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = newsAdapter
        }
    }

    private fun observeViewModel() {
        // Implementasi observasi LiveData dari ViewModel jika diperlukan
        homeViewModel.text.observe(viewLifecycleOwner) { newText ->
            // Lakukan sesuatu dengan data yang diobservasi jika diperlukan
        }
    }

    private fun getDataList(): List<NewsAdapter.ItemData> {
        return listOf(
            NewsAdapter.ItemData(
                "Kementerian Pertanian Dorong Sinergi Monitoring PAT dan Pompanisasi Padi",
                "Banten (14/6) – Kementerian Pertanian terus berupaya meningkatkan produksi pangan nasional, salah satu langkah penting yang dilakukan adalah monitoring...",
                R.drawable.news_satu,
                "https://ditjenbun.pertanian.go.id/kementerian-pertanian-dorong-sinergi-monitoring-pat-dan-pompanisasi-padi/"
            ),
            NewsAdapter.ItemData(
                "Mentan Ajak Petani Kalteng Percepat Optimasi dan Pompanisasi",
                "Palangkaraya – Menteri Pertanian (Mentan) Andi Amran Sulaiman mengajak para petani di Kalimantan Tengah (Kalteng) untuk segera memanfaatkan bantuan...",
                R.drawable.news_dua,
                "https://ditjenbun.pertanian.go.id/mentan-ajak-petani-kalteng-percepat-optimasi-dan-pompanisasi/"
            ),
            NewsAdapter.ItemData(
                "Berlimpahnya Produk Perkebunan Mewarnai Agrofood Expo",
                "Jakarta – Indonesian Agricultural Food & Beverage Industry (Agrofood) Exhibition kembali digelar di Jakarta Convention Center (JCC) selama 3...",
                R.drawable.news_tiga,
                "https://ditjenbun.pertanian.go.id/berlimpahnya-produk-perkebunan-mewarnai-agrofood-expo/"
            ),
            NewsAdapter.ItemData(
                "Petani Tebu Purbalingga Terima Manfaat Hingga Dua Tahun, Kementan Lakukan Ini",
                "Purbalingga – Petani tebu di Kabupaten Purbalingga, Jawa Tengah terima manfaat bantuan perluasan tebu yang dialokasikan Kementerian Pertanian melalui...",
                R.drawable.news_empat,
                "https://ditjenbun.pertanian.go.id/petani-tebu-purbalingga-terima-manfaat-hingga-dua-tahun/"
            ),
            NewsAdapter.ItemData(
                "Bersama Perkuat Hilirisasi, Kementan – BPDPKS Hasilkan Ragam Turunan Sawit",
                "Jakarta – Direktur Jenderal (Dirjen) Perkebunan, Andi Nur Alam Syah menghadiri kegiatan Refleksi Sembilan Tahun Badan Pengelola Dana Perkebunan...",
                R.drawable.news_lima,
                "https://ditjenbun.pertanian.go.id/bersama-perkuat-hilirisasi-kementan-bpdpks-hasilkan-ragam-turunan-sawit/"
            ),
            NewsAdapter.ItemData(
                "Kementan Gandeng UGM & IPB, Ciptakan Varietas Unggul Demi Perluas Areal Tanam Padi, Genjot Produksi Padi Lewat Program Kesatria",
                "Banten – Menteri Pertanian (Mentan) Andi Amran Sulaiman tugaskan jajarannya genjot terus produksi dan jaga produktivitas pertanian sekaligus tingkatkan...",
                R.drawable.news_enam,
                "https://ditjenbun.pertanian.go.id/kementan-gandeng-ugm-ipb-ciptakan-varietas-unggul-demi-perluas-areal-tanam-padi/"
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
