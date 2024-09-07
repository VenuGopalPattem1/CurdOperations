import axios from 'axios';
import "./Stayle.css"; // Custom CSS for additional styling
import { Link, useNavigate } from 'react-router-dom';
import React, { useEffect, useState } from 'react';
import './Stayle.css'; // Custom CSS for futuristic styling

function Data() {
    const navigate = useNavigate();
    const [data, setData] = useState([]);

    useEffect(() => {
        axios({
            method: 'get',
            url: 'http://localhost:8080/app/getAll'
        }).then(response => {
            setData(response.data);
        }).catch(error => {
            console.error("There was an error fetching the data!", error);
        });
    }, []);

    const handleDelete = (e) => {
        const playerId = e.target.value;
        if (window.confirm("Are you sure you want to delete this player?")) {
            axios({
                method: 'delete',
                url: `http://localhost:8080/app/delete/${playerId}`
            }).then(() => {
                alert("Player deleted successfully!");
                setData(data.filter(player => player.playerId !== playerId));
            }).catch(error => {
                alert("Failed to delete the player.");
                console.error("There was an error deleting the player!", error);
            });
        }
    }

    return (
        <div className="container mt-5">
            <h3 className="text-center text-primary mb-4">Team and Their Players Data</h3>
            <div className="d-flex justify-content-center">
                <table className="table table-light table-hover table-bordered text-center">
                    <thead className="table-info">
                        <tr>
                            <th>Player Id</th>
                            <th>Player Name</th>
                            <th>Role</th>
                            <th>Salary</th>
                            <th>Nation</th>
                            <th>Status</th>
                            <th>Team Id</th>
                            <th>Team Name</th>
                            <th>Owner</th>
                            <th colSpan={2}>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            data.length > 0 ? data.map(player => (
                                <tr key={player.playerId}>
                                    <td>{player.playerId}</td>
                                    <td>{player.name}</td>
                                    <td>{player.role}</td>
                                    <td>${player.salary}</td>
                                    <td>{player.nation}</td>
                                    <td className={player.status === "Active" ? "text-success" : "text-danger"}>
                                        {player.status}
                                    </td>
                                    <td>{player.team.teamId}</td>
                                    <td>{player.team.teamName}</td>
                                    <td>{player.team.owner}</td>
                                    <td>
                                        <Link to={`/edit/${player.playerId}`}>
                                            <button className="btn btn-warning btn-sm me-2">
                                                <i className="bi bi-pencil-square"></i> Edit
                                            </button>
                                        </Link>
                                    </td>
                                    <td>
                                        <button
                                            onClick={handleDelete}
                                            value={player.playerId}
                                            className="btn btn-danger btn-sm"
                                        >
                                            <i className="bi bi-trash-fill"></i> Delete
                                        </button>
                                    </td>
                                </tr>
                            )) : (
                                <tr>
                                    <td colSpan="10">No players found.</td>
                                </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>
        </div>
    );
}

export default Data;
