import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/api";
import "./AddList.css"; // optional css

export default function AddList() {
  const [allItems, setAllItems] = useState([]);
  const [filteredItems, setFilteredItems] = useState([]);
  const [query, setQuery] = useState("");
  const [selected, setSelected] = useState([]);
  const navigate = useNavigate();

  // Load all items on mount
  useEffect(() => {
    api.get("/api/items").then(res => {
      setAllItems(res.data);
      setFilteredItems(res.data);
    });
  }, []);

  // Filter items on each keystroke
  useEffect(() => {
    if (!query) {
      setFilteredItems(allItems);
    } else {
      const q = query.toLowerCase();
      setFilteredItems(
        allItems.filter(item => item.name.toLowerCase().includes(q))
      );
    }
  }, [query, allItems]);

  const toggleSelect = (item) => {
    setSelected(prev =>
      prev.includes(item.name)
        ? prev.filter(i => i !== item.name)
        : [...prev, item.name]
    );
  };

  const goToMap = () => {
    // navigate to /map with selected items in state
    navigate("/map", { state: { items: selected } });
  };

  return (
    <div className="addlist-container">
      <h1 className="title">Add Items to List</h1>

      {/* Search Bar */}
      <input
        type="text"
        className="search-input"
        placeholder="Search items..."
        value={query}
        onChange={e => setQuery(e.target.value)}
      />

      {/* Item List */}
      <div className="items-list">
        {filteredItems.map(item => (
          <div
            key={item.id}
            className={`item-row ${selected.includes(item.name) ? "selected" : ""}`}
            onClick={() => toggleSelect(item)}
          >
            {item.name}
          </div>
        ))}
      </div>

      {/* Navigation Button */}
      {selected.length > 0 && (
        <button className="navigate-btn" onClick={goToMap}>
          Navigate Path ({selected.length})
        </button>
      )}
    </div>
  );
}
