import axios from 'axios';
import { useFormik } from 'formik';
import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import './Stayle.css'; // Custom CSS for futuristic styling

function Edit() {
    const param = useParams();
    const navigate = useNavigate();
    const [data, setData] = useState({
        playerId: "",
        name: "",
        role: "",
        salary: "",
        nation: "",
        status: "",
        team: {
            teamId: "",
            teamName: "",
            owner: "",
        }
    });

    const formik = useFormik({
        initialValues: {
            playerId: data.playerId,
            name: data.name,
            role: data.role,
            salary: data.salary,
            nation: data.nation,
            status: data.status,
            team: {
                teamId: data.team.teamId,
                teamName: data.team.teamName,
                owner: data.team.owner,
            },
        },
        enableReinitialize: true,
        onSubmit: (values) => {
            axios({
                method: 'put',
                url: 'http://localhost:8080/app/update',
                data: values
            }).then(() => {
                alert("Player details updated successfully!");
                navigate("/info");
            }).catch((error) => {
                alert("An error occurred while updating player details.");
                console.error(error);
            });
        },
    });

    useEffect(() => {
        axios({
            method: 'get',
            url: `http://localhost:8080/app/get/${param.id}`
        }).then((res) => {
            setData(res.data);
        }).catch((error) => {
            console.error("Error fetching player data", error);
        });
    }, [param.id]);

    return (
        <div className="container-fluid edit-form-container">
            <div className="form-box">
                <h3 className="text-center mb-4 form-title">Edit Player Details</h3>
                <form onSubmit={formik.handleSubmit}>
                    <div className="row mb-3">
                        <div className="col-md-6">
                            <label className="form-label">Player ID</label>
                            <input
                                type="number"
                                className="form-control futuristic-input"
                                name="playerId"
                                value={formik.values.playerId}
                                onChange={formik.handleChange}
                                disabled
                            />
                        </div>
                        <div className="col-md-6">
                            <label className="form-label">Player Name</label>
                            <input
                                type="text"
                                className="form-control futuristic-input"
                                name="name"
                                value={formik.values.name}
                                onChange={formik.handleChange}
                                placeholder="Enter player name"
                                required
                            />
                        </div>
                    </div>

                    <div className="row mb-3">
                        <div className="col-md-6">
                            <label className="form-label">Player Role</label>
                            <input
                                type="text"
                                className="form-control futuristic-input"
                                name="role"
                                value={formik.values.role}
                                onChange={formik.handleChange}
                                placeholder="Enter player role"
                                required
                            />
                        </div>
                        <div className="col-md-6">
                            <label className="form-label">Player Salary</label>
                            <input
                                type="number"
                                className="form-control futuristic-input"
                                name="salary"
                                value={formik.values.salary}
                                onChange={formik.handleChange}
                                placeholder="Enter player salary"
                                required
                            />
                        </div>
                    </div>

                    <div className="row mb-3">
                        <div className="col-md-6">
                            <label className="form-label">Player Nation</label>
                            <input
                                type="text"
                                className="form-control futuristic-input"
                                name="nation"
                                value={formik.values.nation}
                                onChange={formik.handleChange}
                                placeholder="Enter player nation"
                                required
                            />
                        </div>
                        <div className="col-md-6">
                            <label className="form-label">Player Status</label>
                            <input
                                type="text"
                                className="form-control futuristic-input"
                                name="status"
                                value={formik.values.status}
                                onChange={formik.handleChange}
                                placeholder="Active/Inactive"
                                required
                            />
                        </div>
                    </div>

                    <h5 className="mt-4">Team Details</h5>
                    <div className="row mb-3">
                        <div className="col-md-6">
                            <label className="form-label">Team ID</label>
                            <input
                                type="number"
                                className="form-control futuristic-input"
                                name="team.teamId"
                                value={formik.values.team.teamId}
                                onChange={formik.handleChange}
                                disabled
                            />
                        </div>
                        <div className="col-md-6">
                            <label className="form-label">Team Name</label>
                            <input
                                type="text"
                                className="form-control futuristic-input"
                                name="team.teamName"
                                value={formik.values.team.teamName}
                                onChange={formik.handleChange}
                                placeholder="Enter team name"
                                required
                            />
                        </div>
                    </div>

                    <div className="row mb-4">
                        <div className="col-md-12">
                            <label className="form-label">Team Owner</label>
                            <input
                                type="text"
                                className="form-control futuristic-input"
                                name="team.owner"
                                value={formik.values.team.owner}
                                onChange={formik.handleChange}
                                placeholder="Enter team owner"
                                required
                            />
                        </div>
                    </div>

                    <button type="submit" className="btn futuristic-btn w-100">Submit Changes</button>
                </form>
            </div>
        </div>
    );
}

export default Edit;
