import type { Metadata } from "next";
import { Inter } from 'next/font/google';
import "./globals.css";

export const metadata: Metadata = {
  title: "Clients Next APP",
  description: "Full-Stack Tech Test By Othmane DERRAR",
  authors: [
    {
      name: "Othmane DERRAR",
      url: "https://github.com/OthDr",
    },
  ],
  keywords: ["Next.js", "React", "Dark Mode", "Tailwind CSS"],
  creator: "Othmane DERRAR"
};

const inter = Inter({ subsets: ['latin'] });

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <body className={`${inter.className} bg-white text-black dark:bg-gray-900 dark:text-white transition-colors`}>
        {children}
      </body>
    </html>
  );
}
