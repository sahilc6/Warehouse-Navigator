import { useState } from "react";
import api from "../api/api";

export default function SearchBar({ onResults }) {
  const [query, setQuery] = useState("");

  const handleSearch = async (e) => {
    e.preventDefault();
    if (!query) return;
    const { data } = await api.get(`/api/items/search?q=${query}`);
    onResults(data);
  };

  return (
    <form onSubmit={handleSearch} className="flex gap-2 p-2">
      <input
        type="text"
        placeholder="Search items..."
        className="border p-2 flex-1"
        value={query}
        onChange={(e) => setQuery(e.target.value)}
      />
      <button className="bg-blue-500 text-white px-4 py-2">Search</button>
    </form>
  );
}
