import React from "react";

function ActorItem({ actor, onEdit, onDelete }) {
  return (
    <tr>
      <td>{actor.id}</td>
      <td>{actor.name}</td>
      <td>{actor.age}</td>
      <td>
        <button onClick={() => onEdit(actor)}>Edit</button>
        <button onClick={() => onDelete(actor.id)}>Delete</button>
      </td>
    </tr>
  );
}

export default ActorItem;
