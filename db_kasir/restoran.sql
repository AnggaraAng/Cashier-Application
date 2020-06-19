-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 22 Apr 2019 pada 14.29
-- Versi server: 10.1.32-MariaDB
-- Versi PHP: 5.6.36

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `restoran`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `menu`
--

CREATE TABLE `menu` (
  `kode_menu` varchar(5) NOT NULL,
  `nama_menu` varchar(50) NOT NULL,
  `harga_menu` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `menu`
--

INSERT INTO `menu` (`kode_menu`, `nama_menu`, `harga_menu`) VALUES
('BKS01', 'Bakso biasa', 7000),
('MAY01', 'Mie Ayam', 6000),
('MGR01', 'Mie Goreng', 7000),
('NSG01', 'Nasi Goreng ', 7000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `nota_resto`
--

CREATE TABLE `nota_resto` (
  `id_nota` int(11) NOT NULL,
  `tanggal` varchar(10) DEFAULT NULL,
  `total` int(12) NOT NULL,
  `di_karyawan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `nota_resto`
--

INSERT INTO `nota_resto` (`id_nota`, `tanggal`, `total`, `di_karyawan`) VALUES
(1, '22-04-2019', 68000, 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `id_nota` int(11) NOT NULL,
  `kode_menu` varchar(50) NOT NULL,
  `jumlah` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`id_nota`, `kode_menu`, `jumlah`) VALUES
(1, 'MAY01', 2),
(1, 'NSG01', 3),
(1, 'BKS01', 5);

-- --------------------------------------------------------

--
-- Struktur dari tabel `user_karyawan`
--

CREATE TABLE `user_karyawan` (
  `id_karyawan` int(11) NOT NULL,
  `nama_lengkap` varchar(50) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `user_karyawan`
--

INSERT INTO `user_karyawan` (`id_karyawan`, `nama_lengkap`, `username`, `password`) VALUES
(1, 'Josua Ade S', 'josua', '12345'),
(2, 'Jaka Ade Putra', 'jaka', '12345');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`kode_menu`);

--
-- Indeks untuk tabel `nota_resto`
--
ALTER TABLE `nota_resto`
  ADD PRIMARY KEY (`id_nota`),
  ADD KEY `di_karyawan` (`di_karyawan`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD KEY `id_nota` (`id_nota`,`kode_menu`),
  ADD KEY `kode_menu` (`kode_menu`);

--
-- Indeks untuk tabel `user_karyawan`
--
ALTER TABLE `user_karyawan`
  ADD PRIMARY KEY (`id_karyawan`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `nota_resto`
--
ALTER TABLE `nota_resto`
  MODIFY `id_nota` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `user_karyawan`
--
ALTER TABLE `user_karyawan`
  MODIFY `id_karyawan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `nota_resto`
--
ALTER TABLE `nota_resto`
  ADD CONSTRAINT `nota_resto_ibfk_1` FOREIGN KEY (`di_karyawan`) REFERENCES `user_karyawan` (`id_karyawan`);

--
-- Ketidakleluasaan untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`id_nota`) REFERENCES `nota_resto` (`id_nota`),
  ADD CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`kode_menu`) REFERENCES `menu` (`kode_menu`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
