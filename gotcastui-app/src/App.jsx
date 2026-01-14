import { useState } from "react";
import ActorForm from "./components/ActorForm";
import ActorList from "./components/ActorList";

function App() {
  const [selectedActor, setSelectedActor] = useState(null);
  const [refreshKey, setRefreshKey] = useState(0); // key to trigger list refresh

  const handleEdit = (actor) => {
    setSelectedActor(actor);
  };

  const handleSuccess = () => {
    setSelectedActor(null);
    setRefreshKey((prev) => prev + 1); // triggers ActorList to reload
  };

  return (
    <div style={{ padding: "20px" }}>
      <ActorForm selectedActor={selectedActor} onSuccess={handleSuccess} />
      <ActorList key={refreshKey} onEdit={handleEdit} />
    </div>
  );
}

export default App;
