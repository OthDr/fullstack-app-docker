'use client';
import { useState } from 'react';

interface Props {
  onSearch: (query: string) => void;
  loading: boolean;
}

export default function SearchInput({ onSearch, loading }: Props) {
  const [query, setQuery] = useState('');

  const handleClick = () => {
    if (query.trim()) {
      onSearch(query);
    }
  };

  return (
    <div className="flex flex-col md:flex-row gap-4 justify-center items-center">
      <input
        type="text"
        placeholder="Search a person"
        value={query}
        onChange={(e) => setQuery(e.target.value)}
        className="bg-slate-200 dark:bg-gray-100 p-3 rounded-xl w-full md:flex-1 text-gray-800 placeholder:text-gray-500 focus:outline-none focus:ring-2 focus:ring-[#3219EF]"
      />
      <button
        onClick={handleClick}
        disabled={loading || !query.trim()}
        className="bg-[#3219EF] text-white px-6 py-3 rounded-xl font-semibold hover:bg-indigo-700 transition disabled:opacity-50"
      >
        {loading ? 'Searching...' : 'SEARCH'}
      </button>
    </div>
  );
}
