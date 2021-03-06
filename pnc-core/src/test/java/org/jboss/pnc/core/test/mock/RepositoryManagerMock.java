package org.jboss.pnc.core.test.mock;

import org.jboss.pnc.model.BuildCollection;
import org.jboss.pnc.model.ProjectBuildConfiguration;
import org.jboss.pnc.model.ProjectBuildResult;
import org.jboss.pnc.model.RepositoryType;
import org.jboss.pnc.spi.repositorymanager.RepositoryConfiguration;
import org.jboss.pnc.spi.repositorymanager.RepositoryConnectionInfo;
import org.jboss.pnc.spi.repositorymanager.RepositoryManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by <a href="mailto:matejonnet@gmail.com">Matej Lazar</a> on 2014-11-25.
 */
public class RepositoryManagerMock implements RepositoryManager {

    @Override
    public RepositoryConfiguration createRepository(ProjectBuildConfiguration projectBuildConfiguration,
            BuildCollection buildCollection) {
        return new RepositoryConfiguration() {
            @Override
            public RepositoryType getType() {
                return RepositoryType.MAVEN;
            }

            @Override
            public String getId() {
                return "test";
            }

            @Override
            public RepositoryConnectionInfo getConnectionInfo() {
                return new RepositoryConnectionInfo() {
                    // TODO: This is not connected to anything...
                    String repo = "http://localhost:8090/api/groups/test";

                    @Override
                    public String getToolchainUrl() {
                        return repo;
                    }

                    @Override
                    public Map<String, String> getProperties() {
                        Map<String, String> props = new HashMap<>();
                        props.put("altDeploymentRepository", "test::default::" + repo);

                        return props;
                    }

                    @Override
                    public String getDependencyUrl() {
                        return repo;
                    }

                    @Override
                    public String getDeployUrl() {
                        return repo;
                    }
                };
            }
        };
    }

    @Override
    public void persistArtifacts(RepositoryConfiguration repository, ProjectBuildResult buildResult) {
    }

    @Override
    public boolean canManage(RepositoryType managerType) {
        return true;
    }

}
