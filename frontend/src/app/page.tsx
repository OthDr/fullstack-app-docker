'use client';

import { useState } from 'react';
import SearchInput from './components/SearchInput';
import ClientTable from './components/ClientsTable';
import ErrorMessage from './components/ErrorMessage';
import DarkToggle from './components/DarkToggle';
import { API_ENDPOINTS, APP_CONFIG } from '@/config/app';

interface Client {
  nom: string;
  prenom: string;
  email: string;
}

export default function SearchPage() {
  const [results, setResults] = useState<Client[]>([]);
  const [error, setError] = useState('');
  const [loading, setLoading] = useState(false);

  const handleSearch = async (query: string) => {
    setError('');
    setLoading(true);
    setResults([]);

    try {

      const res = await fetch( APP_CONFIG.API_BASE_URL + API_ENDPOINTS.CLIENTS.SEARCH + `?name=${encodeURIComponent(query)}`);

      if (!res.ok) {
        const err = await res.json();
        throw new Error(err?.error || 'Unexpected error');
      }

      const data = await res.json();
      setResults(data);
    } catch (err: any) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="flex flex-col h-screen w-full md:p-4 bg-white text-slate-900 dark:bg-slate-950 dark:text-gray-100">
      
      <h1 className=" h-1/5 text-5xl md:text-7xl text-center p-6 dark:text-white">Search Page <DarkToggle /></h1>

      <div className=" h-full flex flex-col items-start justify-center">
        <div className="p-6 w-full max-w-4xl mx-auto space-y-6">
          <SearchInput onSearch={handleSearch} loading={loading} />

          {error && <ErrorMessage message={error} />}

          {!error && results.length > 0 && <ClientTable clients={results} />}

          {!error && results.length === 0 && !loading && (
            <div className="text-center text-gray-500 mt-6">No results found.</div>
          )}
        </div>
      </div>
    </div>
  );
}
