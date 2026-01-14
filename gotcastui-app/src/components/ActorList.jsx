import { useState, useEffect } from "react";
import { getActors, deleteActor } from "../services/actorService";
import ActorItem from "./ActorItem";

function ActorList({ onEdit }) {
  const [actors, setActors] = useState([]);

  const fetchActors = async () => {
    try {
      const response = await getActors();
      setActors(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  useEffect(() => {
    fetchActors();
  }, []); // list will reload on mount or key change

  const handleDelete = async (id) => {
    if (window.confirm("Are you sure?")) {
      await deleteActor(id);
      fetchActors(); // refresh list after deletion
    }
  };

  return (
    <table border="1" cellPadding="5" style={{ width: "100%" }}>
      <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Age</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        {actors.map((actor) => (
          <ActorItem key={actor.id} actor={actor} onEdit={onEdit} onDelete={handleDelete} />
        ))}
      </tbody>
    </table>
  );
}

export default ActorList;
