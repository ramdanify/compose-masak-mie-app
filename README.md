# MasakMie

Aplikasi Android interaktif berbasis **Jetpack Compose** yang mensimulasikan langkah-langkah memasak mie instan secara bertahap. Proyek ini dikembangkan sebagai tugas mata pelajaran **Pemrograman Mobile (Bu Rizka)** yang diadaptasi dari studi kasus *Lemonade App* pada modul resmi [Google Developers - Android Basics with Compose Unit 2 Pathway 2](https://developer.android.com/courses/pathways/android-basics-compose-unit-2-pathway-2).

---

## Fitur Utama

- **Alur Interaktif Multi-Langkah**: Terdiri dari 8 tahap simulasi memasak mie instan dari awal hingga siap disajikan.
- **Logika Tap Acak (Random Tap Count)**: Pada tahap merebus mie (`lagi_dimasak`), pengguna harus menekan (*tap*) gambar secara acak sebanyak 2 hingga 5 kali sebelum dapat berlanjut ke tahap berikutnya.
- **Modern Jetpack Compose UI**:
  - Menggunakan komponen **Material 3** (`Scaffold`, `CenterAlignedTopAppBar`, `Surface`, `Button`).
  - Arsitektur pengelolaan *State* menggunakan `remember` dan `mutableIntStateOf`.
- **Pengelolaan Resource Terpisah**: Memanfaatkan `strings.xml` untuk lokalisasi teks dan `dimens.xml` untuk tata letak yang rapi dan fleksibel.

---

## Alur Langkah Memasak (App Flow)

1. **Warung Madura**: Tap untuk membeli mie instan di Warung Madura.
2. **Indomie Goreng**: Tap untuk menyiapkan bungkus Indomie Goreng.
3. **Masukkan Mie**: Tap untuk memasukkan mie ke dalam air mendidih.
4. **Rebus Mie (Random Tap)**: Tap gambar secara acak (2–5 kali) hingga mie matang.
5. **Tiriskan Mie**: Tap untuk meniriskan air rebusan mie.
6. **Tuang ke Piring**: Tap untuk menaruh mie di atas piring.
7. **Bumbui & Aduk**: Tap untuk meratakan bumbu dengan mie.
8. **Siap Disantap**: Mie lezat siap dinikmati! Tap untuk mengulang simulasi dari awal.

---

## Teknologi & Peralatan

- **Bahasa Pemrograman**: Kotlin
- **UI Framework**: Jetpack Compose (Material 3)
- **Minimum SDK**: API 24 (Android 7.0 Nougat)
- **Target SDK**: API 36 (Android 16)
- **Build Tool**: Gradle (Kotlin DSL)

---

## Informasi Tugas

- **Mata Pelajaran**: Pemrograman Mobile
- **Guru**: Bu Rizka
- **Referensi Codelab**: [Android Basics with Compose - Unit 2 Pathway 2](https://developer.android.com/courses/pathways/android-basics-compose-unit-2-pathway-2)
