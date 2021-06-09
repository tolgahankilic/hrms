package tolgahankilic.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "curriculum_vitaes")
public class CurriculumVitae {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "cover_letter")
	private String coverLetter;

	@Column(name = "picture_url")
	private String pictureUrl = "https://res.cloudinary.com/tolgahankilic/image/upload/v1623241476/xbqbpqpdnrx7xtqmdddy.png";

	@ManyToOne()
	@JoinColumn(name = "social_media_id")
	private SocialMedia socialMedia;

	@ManyToOne()
	@JoinColumn(name = "jobseeker_id")
	private JobSeeker jobSeeker;

	@OneToMany(mappedBy = "curriculumVitae")
	private List<Education> educations;

	@OneToMany(mappedBy = "curriculumVitae")
	private List<JobExperience> jobExperiences;

	@OneToMany(mappedBy = "curriculumVitae")
	private List<JobSeekerLanguage> jobSeekerLanguages;

	@OneToMany(mappedBy = "curriculumVitae")
	private List<Technology> technologies;
}
